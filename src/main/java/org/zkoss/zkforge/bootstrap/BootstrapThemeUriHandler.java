package org.zkoss.zkforge.bootstrap;

import org.slf4j.*;
import org.zkoss.lang.Library;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.util.*;

import java.util.*;

public class BootstrapThemeUriHandler implements ThemeURIHandler {
    // Key to determine which theme option to use: "default", "custom", "none"
    public static final String THEME_OPTION_KEY = BootstrapThemeUriHandler.class.getPackage().getName() ;
    public static final String CUSTOM_CSS_KEY = BootstrapThemeUriHandler.class.getPackage().getName() + ".custom";
    public static final String BASE_URI = "/webjars/bootstrap/5.1.0/css/";
    public enum Option { defaultStyle, custom, none }

    private static final Logger logger = LoggerFactory.getLogger(BootstrapThemeUriHandler.class);

    /**
     * With any Servlet 3 compatible container, the WebJars that are in the WEB-INF/lib directory are automatically made available as static resources. This works because anything in a META-INF/resources directory in a JAR in WEB-INF/lib is automatically exposed as a static resource. Please note that in case of Tomcat the JarScanner should not be configured to skip the WebJars (e.g. when jarsToSkip is set to * add the WebJars to jarsToScan).
     * https://www.webjars.org/documentation#servlet3
     */
    @Override
    public void modifyThemeURIs(Execution exec, ThemeURIModifier modifier) {
        if (!isServlet3OrAbove()){
            logger.warn("BootstrapHelper requires Servlet 3.0+ support to include css files." +
                    "Please ensure your environment is compatible.");
        }

        String option = Library.getProperty(THEME_OPTION_KEY, "defaultStyle");
        Option opt;
        try {
            opt = Option.valueOf(option);
        } catch (IllegalArgumentException ex) {
            opt = Option.defaultStyle;
        }
        switch (opt) {
            case custom:
                addCustomStyles(modifier);
                break;
            case none:
                // No additional URIs to add
                break;
            case defaultStyle:
            default:
                modifier.add(BASE_URI + produceCssFile("grid"));
                modifier.add(BASE_URI + produceCssFile("utilities"));
                // because bootstrap-reboot.css affects ZK styles, we do not add it by default
        }
    }

    /**
     * Add custom Bootstrap CSS files based on the CUSTOM_CSS_KEY property.
     * Suggested values: "grid", "reboot", "utilities"
     */
    protected void addCustomStyles(ThemeURIModifier modifier) {
        List<String> props = Library.getProperties(CUSTOM_CSS_KEY);
        for (String key : props) {
            String cssFile = produceCssFile(key);
            modifier.add(BASE_URI + cssFile);
        }
    }

    private static String produceCssFile(String key) {
        return "bootstrap-" + key.trim() + ".min.css";
    }

    /**
     * Checks if running in a Servlet 3.0+ container (javax or jakarta).
     * @return true if Servlet 3.0+ is detected, false otherwise
     */
    public static boolean isServlet3OrAbove() {
        String[] contextClassNames = {
            "javax.servlet.ServletContext",
            "jakarta.servlet.ServletContext"
        };
        for (String className : contextClassNames) {
            try {
                Class<?> ctxClass = Class.forName(className);
                ctxClass.getMethod("getServletRegistration", String.class);
                return true;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                // try next
            }
        }
        return false;
    }
}