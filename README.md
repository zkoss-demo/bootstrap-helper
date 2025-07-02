# ZK Bootstrap Helper

Simplify the way to include [Bootstrap](https://getbootstrap.com/) CSS on all ZK pages (application scope).

Bootstrap is a good companion for ZK with the following usages:
* Layout a page with [the responsive grid system](https://getbootstrap.com/docs/4.6/getting-started/introduction/)
* Style a page with [utility CSS classes](https://getbootstrap.com/docs/4.6/utilities/borders/)

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
        <value>reboot</value>
    </list>
</library-property>
```

Supported values: see [Bootstrap CSS Files](#bootstrap-css-files) section below.

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
bootstrap/css/
bootstrap.css
bootstrap.css.gz
bootstrap.min.css.gz
bootstrap.min-jsf.css
bootstrap.min-jsf.css.gz
bootstrap-grid.css
bootstrap-grid.css.gz
bootstrap-grid.min.css.gz
bootstrap-grid.min-jsf.css
bootstrap-grid.min-jsf.css.gz
bootstrap-grid-jsf.css
bootstrap-grid-jsf.css.gz
bootstrap-jsf.css
bootstrap-jsf.css.gz
bootstrap-reboot.css
bootstrap-reboot.css.gz
bootstrap-reboot.min.css.gz
bootstrap-reboot.min-jsf.css
bootstrap-reboot.min-jsf.css.gz
bootstrap-reboot-jsf.css
bootstrap-reboot-jsf.css.gz
```
see https://getbootstrap.com/docs/5.0/getting-started/contents/

# Version naming
Its major version is the same as Bootstrap's major version it includes.

| ZK Bootstrap Helper | Bootstrap |
|---------------------|-----------|
| 5.x                 | 5.x       |
| 4.x                 | 4.x       |

# Testing
run `jetty:run`
visit http://localhost:8080/bootstrap-helper/ to see a demo page.
inspect the page source to see which CSS files are included.

# Release
1. change the version in `pom.xml` with [upVer](release/upVer)
2. run [release](release/release) 
3. upload to file server
4. publish to Maven CE repository with [PBFUM](http://jenkins2/view/All/job/PBFUM/)