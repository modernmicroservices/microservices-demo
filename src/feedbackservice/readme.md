## Feedback Service
Service with basic CRUD operations for customer feedback

```
docker build  -t modernmicroservices/feedbackservice .
docker run -d -p 8080:8080 modernmicroservices/feedbackservice

kubectl create -f deployment.yaml
kubectl port-forward feedbackapp 8080:8080
```


### Examples
```
curl -H "Content-Type: application/json" -X POST http://localhost:8080/feedback -d "{\"content\":\"Test Value\"}"

curl --request GET  http://localhost:8080/feedback/1
```