# VVecMath
[ ![Download](https://api.bintray.com/packages/miho/VVecMath/VVecMath/images/download.svg) ](https://bintray.com/miho/VVecMath/VVecMath/_latestVersion) [![Javadocs](https://www.javadoc.io/badge/eu.mihosoft.vvecmath/vvecmath.svg)](https://www.javadoc.io/doc/eu.mihosoft.vvecmath/vvecmath)
![Java CI with Gradle](https://github.com/miho/VVecMath/workflows/Java%20CI%20with%20Gradle/badge.svg)

Vector math package used by JCSG, VRL and VMF.

## How to Build VVecMath

### Requirements

- Java >= 1.8 (currently tested with Java 11)
- Internet connection (dependencies are downloaded automatically)
- IDE: [Gradle](http://www.gradle.org/) Plugin (not necessary for command line usage)

### IDE

Open the `VVecMath` [Gradle](http://www.gradle.org/) project in your favourite IDE (tested with NetBeans 8.2) and build it
by calling the `assemble` task.

### Command Line

Navigate to the [Gradle](http://www.gradle.org/) project (e.g., `path/to/VVecMath`) and enter the following command

#### Bash (Linux/OS X/Cygwin/other Unix-like shell)

    bash gradlew assemble
    
#### Windows (CMD)

    gradlew assemble
