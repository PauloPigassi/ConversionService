## 📃 Resources
- First you need to add a user to the system, using the following route as POST:
    ```
    /users
    ```

providing in the body of the request only the name:
```
{
    "name": "Jessica"
}
```
this request will return the data of the added user:
```
{
    "id": 1,
    "name": "Jessica"
}
```
- To use the conversion of values ​​it is necessary to make a POST request in the path:
```
/currency-convert
```

passing the following parameters:
```
{
  "baseCurrency": "string",
  "baseValue": 0,
  "destinationCurrency": "string",
  "userId": 0
}
```
getting the result in the following format:
```
{
  "baseCurrency": "string",
  "baseValue": 0,
  "conversionTax": 0,
  "date": "string",
  "destinationCurrency": "string",
  "destinationValue": 0,
  "id": 0,
  "userId": 0
}
```

