# team2059-scouting-core

<a href="https://github.com/aamijar/team2059-scouting-core/actions"><img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/aamijar/team2059-scouting-core/Maven%20Build?label=CI%2FCD&logo=github"></a>
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/aamijar/team2059-scouting-core/Maven%20Build?color=%23A22160&label=Maven%20Build&logo=apache%20maven&logoColor=%23E4682A">
<img alt="GitHub Workflow Status" src="https://img.shields.io/badge/Java-8-5382A1?logo=java">


This repo has the original java classes that are being used in the FRC scouting app. These include Team, Match, and Competition.

This repo uses the maven tool for building a jar file which is refrenced in the lib folder of the team2059-scouting-android repo.

Commands to compile java classes into jar file:

```
$ mvn clean
$ mvn compile
$ mvn package
```
