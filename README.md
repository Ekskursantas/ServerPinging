# Ping exercise
## Problem statement
We want to test the ping response times from 3 different servers, that we know is in 3 different parts of the world.
We want to prove that the servers response times are dependant on the location of these servers.

## Experiment setup
A prerequisite of our experiment is to find the location of the three servers, so we can compare the response times with the approximate distance from us to the servers location.

These are the three IPs:
- 128.199.144.199
- 167.99.51.33
- 46.101.253.149

We ran each IP through: https://www.iplocation.net/ to get the physical location of the server. Which gave us the following 3 locations

|IP Address|Country|Region|City|
|--|--|--|--|
|128.199.144.199|Singapore|Singapore|Singapore|
|167.99.51.33|United States|New Jersey|Clifton|
|46.101.253.149|Germany|Hessen|Frankfurt am Main|

Check the distance from the pinging location to the given IP address. My location is:
![LOCATION](https://github.com/Ekskursantas/ServerPinging/blob/master/location.png?raw=true)

- From CPH to Singapore there is 9,962.55 km.
- From CPH to Clifton there is 6,187.18  km.
- From CPH to Frankfurt am Main there is 815.60  km.

Using the knowledge we have we could assume that pings to Frankfurt would be the fastest and then goes Clifton and in the end Singapore.

I create a Java program that pings each location 5 times and then in the end calculates all the averages, min and max time for ping.

I am on a Windows 10 OS.
My connection:
![Internet connection](https://github.com/Ekskursantas/ServerPinging/blob/master/speed.png?raw=true?raw=true)

## The experiment
For the experiment I am using Netbeans IDE it is a Java IDE that is able to run out small code.

1. Clone the project
2. Open the source code in your Java IDE.
3. Press run
We will see each ping sent in the Console. When one server is done pinging the average will be displayed as well as the next server will be pinged.

Results:

![Results](https://github.com/Ekskursantas/ServerPinging/blob/master/pings.png?raw=true?raw=true)

## Evaluation
As we can see the the results indicate that the further the server the bigger the delay is.

## Discussion
As we can see there seems to be some kind of relation between distance to the physical server and the ping times.
If the ping is dependent specifically from the distance then in our next few equations we should get three very similar answer when trying to get the ms per km.

- Singapore: 204ms / 9,962.55km= 0.0204766851860217 ms/km
- Clifton: 101ms / 6,187.18 km = 0.0163240765583028 ms/km
- Frankfurt: 23ms / 815.60km = 0.0282000980872977 ms/km

As we can see even though the numbers are small they differ quite a bit when we expect them to be quite similar. So, in the end we can not assume that only distance is the factor for the delay. In the there might be server capabilities and quality that also plays a big part in this scenario.
