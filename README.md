# ZK Bootstrap Helper

Simplify the way to include [Bootstrap](https://getbootstrap.com/) CSS on all ZK pages (application scope).

Bootstrap is a good companion for ZK with the following usages:
* Layout a page with [the responsive grid system](https://getbootstrap.com/docs/5.0/layout/grid/)
* Style a page with [utility CSS classes](https://getbootstrap.com/docs/5.0/utilities/background/)

This addon include Bootstrap [WebJar](https://www.webjars.org/) and its CSS files for you.

# Usage
Include the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.zkoss.zkforge</groupId>
    <artifactId>bootstrap-helper</artifactId>
    <version>${bootstrap-helper.version}</version>
</dependency>
```
Then that's all done if you just need the default usage.

## Default (Grid + Utilities)

By default, the helper includes the following Bootstrap CSS files automatically on all ZK pages:
* `bootstrap-grid.min.css`: the responsive grid system
* `bootstrap-utilities.min.css` : utility CSS classes

You don't need to specify anything in `zk.xml` for this default behavior.

(Note: we don't include bootstrap-reboot.css by default because it affects ZK default styles.)

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

## Supported Custom Values
Check the following css file names to know the allowed custom values, it's the word between `bootstrap-` and `min.css`. (e.g. `grid` for `bootstrap-grid.min.css`).

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

```
see https://getbootstrap.com/docs/5.0/getting-started/contents/

# Version naming
Its major version is the same as Bootstrap's major version it includes.

| ZK Bootstrap Helper | Bootstrap |
|---------------------|-----------|
| 5.x                 | 5.x       |


# Testing
run `jetty:run`
visit http://localhost:8080/bootstrap-helper/ to see a demo page.
inspect the page source to see which CSS files are included.

# Release
1. change the version in `pom.xml`
2. run `release.sh`