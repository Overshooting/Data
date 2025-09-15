A statistical analysis tool based around DataPoint objects that contain only a unit and measurement.


Current features include:

Data Holders:
  DataPoints - Base objects that hold a unit and a measurement

  DataSets - Groups of DataPoints that include basic statistic functions such as mean, median, and mode

  Complex DataPoints - Object types such as Observations and DescribedDataPoints store additional information to DataPoints, and have DataSet type objects to encompass them
  
  Environmental Objects - Helper objects that can store Dates and Times

Tools: 
  DataSet Constructor - Helper tool that allows you to construct a DataSet using command-line inputs

  Calculator - Helper tool that can calculate means, medians, modes, and more of DataSets

  UnitConverter - Unit conversion tool for DataPoints, currently only includes basic metric and imperial unit conversions


Coming Eventually (maybe) features:
  Graph - Extremely undeveloped graphing tool that will eventually allow you to graph complex datasets with custom parameters

