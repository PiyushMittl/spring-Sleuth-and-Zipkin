### Tracing services using Spring cloud Sleuth and Spring cloud Zipkin

Microservices now a days are higly used though it has its own challanges. we develop microservices and use downstream and upstream microservices in one another. some times we go through high latency and other issues due other services and some times its very difficult to go though the log and find out the culprit.

#### What is distributed Tracing

the complexity of microservices increase when we use multiple service layers and hit other api's.Each service call go through multiple layers and call multiple other api hits, some thimes its very difficult to identify the issues with other api's or service call and going though log one by one also consumes lot of time.
Distributed tracing provides a holistic view of requests transiting through multiple services, allowing for immediate identification of issues


#### Distributed Tracing Vocabulary
Span – A span is an individual operation.
Trace – A Trace is an end-to-end latency graph, composed of spans.
Tracers – Tracers records spans and passes context required to connect them into a trace.


