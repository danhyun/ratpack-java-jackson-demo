$ curl localhost:5050
```
{
  "name" : "Matt",
  "age" : 18
}
```

$ curl -H "Content-Type: application/json" -X POST -d '{"name": "Matt", "age": 18}' http://localhost:5050/person
```
You sent Matt who is 18 years old
```
