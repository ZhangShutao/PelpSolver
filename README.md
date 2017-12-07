
PelpSolver
===

## Basic Information

+ __Introduction__:
   `PelpSolver` is a solver for PELP programs runing in windows command console. It is based on `clingo`, which is a famous solver for answer set programs.
+ __Update Date__:  2017.12.7
+ __Author__: Shutao Zhang, Zhizheng Zhang
+ __Environment__: 
	+ OS: Windows 8/10(not tested on other versions)/Linux
	+ JRE: 1.8+

## Installation

Zip file includes PelpSolver, and Clingo5.2, and some examples:

+ `logs`: log directory
+ `resources`: configure files
	+ `log4j.properties`: log configure
	+ `PelpSolver.properties`: configure file of PelpSolver
+ `clingo5.2.exe`: ASP solver for windows
+ `clingo5.2`: ASP solver for linux
+ `examples`: example directory


To install `PelpSolver` on your machine, please follow the steps here:
+ downloading and unziping `PelpSolver.zip`;
+ if `PelpSolver` is running on Linux, following commands are also necessary:
	```
	cd PelpSolver
	chmod 777 clingo5.2
	```

## Usage

`PelpSolver` is a java program. As a result, a java environment is necessary to solve a PELP program with `PelpSolver`. Here is the command:

`java -jar PelpSolver.jar [-opt 1|0] <program file>`

option:

+ opt: `1` for using optimize algorithm, `0` for not. The default value of this option is 0  

###Examples


`java -jar PelpSolver.jar test/alarm.lp`

`java -jar PelpSolver.jar -opt 1 test/3doors.lp`

## Download

[PelpSolver v1.2](https://github.com/ZhangShutao/PelpSolver/files/1538626/PelpSolver.zip)
