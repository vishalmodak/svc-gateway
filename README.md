#Hotel Gateway
This represents a Service Gateway as well as registrar for other services. Runs on port 7979.

This applies relies on 3 services - HotelDetailsService ([svc-hoteldetails](https://stash.hyattdev.com/stash/users/1337135/repos/svc-hoteldetails/browse)) , HotelPricingService ([svc-pricing](https://stash.hyattdev.com/stash/users/1337135/repos/svc-pricing/browse)), HotelRatingService ([svc-rating](https://stash.hyattdev.com/stash/users/1337135/repos/svc-rating/browse))

#To view hystrix metrics 
Run the hystrix dashboard ([hystrix-dashboard](https://stash.hyattdev.com/stash/users/1337135/repos/hystrix-dashboard/browse))

#To consume hystrix stream for processing
Refer to [hystrix monitor](https://stash.hyattdev.com/stash/users/1337135/repos/hystrix-monitor/browse)

#Other Links
| Component | Link |
|-----------| -----|
| Eureka Server | http://localhost:7979 |
| Swagger UI | http://localhost:7979/sdoc.jsp (requires internet access) |
| Hystrix Stream | http://localhost:7980/hystrix.stream | |

##To generate traffic
`seq 100000 | xargs -P 1 -n 1 -I ID curl http://localhost:7979/info/ID`

This uses 5 threads (-P 1) & substitutes ID with sequence number


#Docker notes
##To build the docker image
`docker build -t "gateway" .`

##To delete docker images
`docker rmi gateway`

##To run the image
`docker run -t -i -p 7979:7979 gateway`

This will start an instance of the image, forward port 9000 between the VirtualBox host (boot2docker-vm) and the Docker container
-t -i options will display the stdout