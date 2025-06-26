# ZK Bootstrap Helper

simplify the way to include Bootstrap CSS on all ZK pages.

# Usage

Add the following to your `WEB-INF/zk.xml` to control which Bootstrap CSS files are included:

## Default (Grid + Utilities)

By default, the helper includes both `bootstrap-grid.min.css` and `bootstrap-utilities.min.css`. You don't need to specify anything in `zk.xml` for this default behavior.

## Custom CSS Selection

To include only specific Bootstrap CSS files, set the option to `custom` and specify the desired files as a list in the `.custom` property:

```xml
<library-property>
    <name>org.zkoss.zkforge.bootstrap</name>
    <value>custom</value>
</library-property>
<library-property>
    <name>org.zkoss.zkforge.bootstrap.custom</name>
    <list>
        <value>grid</value>
        <value>utilities</value>
        <!-- or "reboot" -->
    </list>
</library-property>
```

Supported values: `grid`, `utilities`, `reboot`.

## Disable Bootstrap CSS

To disable all automatic Bootstrap CSS inclusion:

```xml
<library-property>
    <name>org.zkoss.zkforge.bootstrap</name>
    <value>none</value>
</library-property>
```

# Example

```xml
<library-property>
    <name>org.zkoss.zkforge.bootstrap</name>
    <value>custom</value>
</library-property>
<library-property>
    <name>org.zkoss.zkforge.bootstrap.custom</name>
    <list>
        <value>grid</value>
    </list>
</library-property>
```

*This will only include `bootstrap-grid.min.css`.*

// ...existing content...

# Bootstrap CSS Files

```text
bootstrap/
├── css/
│   ├── bootstrap-grid.css
│   ├── bootstrap-grid.css.map
│   ├── bootstrap-grid.min.css
│   ├── bootstrap-grid.min.css.map
│   ├── bootstrap-grid.rtl.css
│   ├── bootstrap-grid.rtl.css.map
│   ├── bootstrap-grid.rtl.min.css
│   ├── bootstrap-grid.rtl.min.css.map
│   ├── bootstrap-reboot.css
│   ├── bootstrap-reboot.css.map
│   ├── bootstrap-reboot.min.css
│   ├── bootstrap-reboot.min.css.map
│   ├── bootstrap-reboot.rtl.css
│   ├── bootstrap-reboot.rtl.css.map
│   ├── bootstrap-reboot.rtl.min.css
│   ├── bootstrap-reboot.rtl.min.css.map
│   ├── bootstrap-utilities.css
│   ├── bootstrap-utilities.css.map
│   ├── bootstrap-utilities.min.css
│   ├── bootstrap-utilities.min.css.map
│   ├── bootstrap-utilities.rtl.css
│   ├── bootstrap-utilities.rtl.css.map
│   ├── bootstrap-utilities.rtl.min.css
│   ├── bootstrap-utilities.rtl.min.css.map
│   ├── bootstrap.css
│   ├── bootstrap.css.map
│   ├── bootstrap.min.css
│   ├── bootstrap.min.css.map
│   ├── bootstrap.rtl.css
│   ├── bootstrap.rtl.css.map
│   ├── bootstrap.rtl.min.css
│   └── bootstrap.rtl.min.css.map
└── js/
    ├── bootstrap.bundle.js
    ├── bootstrap.bundle.js.map
    ├── bootstrap.bundle.min.js
    ├── bootstrap.bundle.min.js.map
    ├── bootstrap.esm.js
    ├── bootstrap.esm.js.map
    ├── bootstrap.esm.min.js
    ├── bootstrap.esm.min.js.map
    ├── bootstrap.js
    ├── bootstrap.js.map
    ├── bootstrap.min.js
    └── bootstrap.min.js.map
```

# Version naming
Its major version is the same as Bootstrap's major version it includes.

| ZK Bootstrap Helper | Bootstrap |
|---------------------|-----------|
| 5.x                 | 5.x       |
