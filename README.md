### typesafe-test

#### Build and run tests
Run `mvn install` in `typesafe-test` maven project to execute the tests


#### Description
This project was created to show an issue with `include` in typesafe config

[ConfigTest.java](typesafe-test/app/src/test/java/com/htmsousa/typesafe/ConfigTest.java) tests 3 scenarios where the `main.conf file` imports the `jdbc.conf` file

##### Conf files at root folder of classpath - works as expected
- `${classpath}/test1-jdbc.conf`
- `${classpath}/test1-main.conf`

```
include "test1-jdbc.conf"
```

##### Conf files in same folder in classpath (include with "full path") - works as expected
- `${classpath}/test2/test2-jdbc.conf`
- `${classpath}/test2/test2-main.conf`

```
include "test2/test2-jdbc.conf"
```

##### Conf files in same folder in classpath (include with "relative path") - include fails
- `${classpath}/test3/test3-jdbc.conf`
- `${classpath}/test3/test3-main.conf`

```
include "test3-jdbc.conf"
```
