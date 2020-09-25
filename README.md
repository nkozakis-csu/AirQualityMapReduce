# Air Quality Data Processing with Map Reduce
Author: Nathan Kozakis

## Jobs
### MonitoringSites.CountSitesJob
Calculate total number of unique measuring sites.

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MonitoringSites.CountSitesJob /data/meteorological /data/gases /home/cs455/q1

### MeanCoastSO2.MeanCoastSO2Job

Calculates the mean SO2 for the East and West Coast

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MeanCoastSO2.MeanCoastSO2Job /data/gases /home/cs455/q2

### MeanTimeSO2.MeanTimeSO2Job
Calculate mean SO2 per hour of the day GMT

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MeanTimeSO2.MeanTimeSO2Job /data/gases/hourly_42401_20*.csv /home/cs455/q3

### MeanYearSO2.MeanYearSO2Job
Calculate mean SO2 per year.

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MeanYearSO2.MeanYearSO2Job /data/gases/ /home/cs455/q4

### MeanSummerTemp.MeanSummerTempJob
Calculate mean temperature for summer months (june-aug)

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MeanSummerTemp.MeanSummerTempJob /data/meteorological/ /home/cs455/q5

### Mean HottestSO2.MeanHottestSO2Job

Calculate SO2 for the 10 states with the hottest average summer months (MeanSummerTempJob)

$HADOOP_HOME/bin/hadoop jar AirQualityMapReduce-1.0-SNAPSHOT.jar cs455.hadoop.MeanHottestSO2.MeanHottestSO2Job /data/gases/ /home/cs455/q6

##List of files
src/main/java/cs455/hadoop/MonitoringSites/                         - Q1
src/main/java/cs455/hadoop/MonitoringSites/CountSitesMapper.java    - Mapper for q1 to count number of unique measuring sites
src/main/java/cs455/hadoop/MonitoringSites/CountSitesReducer.java   - reducer and combiner to count unique measuring sites
src/main/java/cs455/hadoop/MonitoringSites/CountSitesJob.java       - Job to count unique measuring sites
src/main/java/cs455/hadoop/MeanCoastSO2/                            - Q2
src/main/java/cs455/hadoop/MeanCoastSO2/MeanCoastSO2Job.java        - Job to count mean SO2 per coast
src/main/java/cs455/hadoop/MeanCoastSO2/MeanCoastSO2Mapper.java     - Mapper to count mean SO2 per coast
src/main/java/cs455/hadoop/MeanTimeSO2/                             - Q3
src/main/java/cs455/hadoop/MeanTimeSO2/MeanTimeSO2Job.java          - Calculate mean SO2 per time GMT
src/main/java/cs455/hadoop/MeanTimeSO2/MeanTimeSO2Mapper.java       - Map SO2 to GMT time
src/main/java/cs455/hadoop/MeanYearSO2/                             - Q4
src/main/java/cs455/hadoop/MeanYearSO2/MeanYearSO2Job.java          - Calculate mean SO2 per year.
src/main/java/cs455/hadoop/MeanYearSO2/MeanYearSO2Mapper.java       - Map SO2 to the year
src/main/java/cs455/hadoop/MeanSummerTemp/                          - Q5
src/main/java/cs455/hadoop/MeanSummerTemp/MeanSummerTempMapper.java - Map Summer (june - aug) temperatures to the state
src/main/java/cs455/hadoop/MeanSummerTemp/MeanSummerTempJob.java    - calculate mean summer temperature per state
src/main/java/cs455/hadoop/MeanHottestSO2/                          - Q6
src/main/java/cs455/hadoop/MeanHottestSO2/MeanHottestSO2Job.java    - Calculate mean SO2 for the top 10 hottest hottest summer states
src/main/java/cs455/hadoop/MeanHottestSO2/MeanHottestSO2Mapper.java - Map SO2 measurement to a top 10 hottest summer state if from one of those states.

src/main/java/cs455/hadoop/FieldIndexes.java                        - Enum with fields used and the index in the array (csv column number starting from 0)
src/main/java/cs455/hadoop/MeanReducer.java                         - General Mean calculating reducer. Used by all but Q1
src/main/java/cs455/hadoop/StateRegions.java                        - Lists and methods to check if state is in east or west coast
