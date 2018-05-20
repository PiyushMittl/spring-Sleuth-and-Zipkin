### Tracing services using Spring cloud Sleuth and Spring cloud Zipkin

Microservices now a days are higly used though it has its own challanges. we develop microservices and use downstream and upstream microservices in one another. some times we go through high latency and other issues due other services and some times its very difficult to go though the log and find out the culprit.

#### What is distributed Tracing

the complexity of microservices increase when we use multiple service layers and hit other api's.Each service call go through multiple layers and call multiple other api hits, some thimes its very difficult to identify the issues with other api's or service call and going though log one by one also consumes lot of time.
Distributed tracing provides a holistic view of requests transiting through multiple services, allowing for immediate identification of issues


#### Distributed Tracing Vocabulary
**Span –** A span is an individual operation.
**Trace –** A Trace is an end-to-end latency graph, composed of spans.
**Tracers –** Tracers records spans and passes context required to connect them into a trace.


#### ![Zipkin](https://zipkin.io/)
Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in microservice architectures. It manages both the collection and lookup of this data. Zipkin’s design is based on the ![Google Dapper paper](https://ai.google/research/pubs/pub36356).

Applications are instrumented to report timing data to Zipkin. The Zipkin UI also presents a Dependency diagram showing how many traced requests went through each application. If you are troubleshooting latency problems or errors, you can filter or sort all traces based on the application, length of trace, annotation, or timestamp. Once you select a trace, you can see the percentage of the total trace time each span takes which allows you to identify the problem application.


we integrate Zipkin with our services or Controller to track the complex flow. to integrate Zipkin service we have to follow following steps.

create sample application using [spring initializer](https://start.spring.io/) where you will have your controllers.

[creating application](https://github.com/PiyushMittl/Sleuth-and-Zipkin/blob/master/im1_create_zipkin.png)

after importing the project add following dependencies to your project.

``` json
compile('io.zipkin.java:zipkin-server')
compile('io.zipkin.java:zipkin-autoconfigure-ui')
``` 

add ***@EnableZipkinServer*** annotation to your application.

``` java
@SpringBootApplication
@EnableZipkinServer
public class ZipkinnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinnApplication.class, args);
	}
}
```

add blow port to your ***application.properties*** file

```
server.port=9411
```

#### Sleuth


