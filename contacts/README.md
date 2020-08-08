###Database details
* I've used H2 in-memory database that will be created along with starting application
* Access to database using this url: http://localhost:8080/h2
* Inside you will see two tables CONTACT and ADDRESS

###API for creating contact

* URL: http://{{domain}}:{{port}}/api/contact/create
* Localhost URL: http://localhost:8080/api/contact/create
* Type of request: POST

Request body:

```
{
  "fullName": "Ahmet Bajric",
  "dateOfBirth": "1994-11-05",
  "address": {
    "city": "Bihac",
    "zipCode": "77000"
  }
}
```

Response body

```
Contact successfully saved.
```

Response code 
 * HTTP STATUS 200 (OK)

###API for getting all existing contacts

* URL: http://{{domain}}:{{port}}/api/contact/get-all-contacts
* Localhost URL: http://localhost:8080/api/contact/get-all-contacts
* Type of request: GET


Response body:

```
[
    {
        "id": 1,
        "fullName": "Ahmet Bajric",
        "dateOfBirth": "1994-11-05T00:00:00.000+00:00",
        "address": {
            "id": 1,
            "city": "Bihac",
            "zipCode": "77000"
        }
    },
    {
        "id": 2,
        "fullName": "Ivo Ivic",
        "dateOfBirth": "1990-10-25T00:00:00.000+00:00",
        "address": {
            "id": 2,
            "city": "Sarajevo",
            "zipCode": "71000"
        }
    }
]
```

Response code 
 * HTTP STATUS 200 (OK)
 
 ###API for getting contacts by zip code

* URL: http://{{domain}}:{{port}}/api/contact/get-by-zip-code/{{zipCode}}
* Localhost URL: http://localhost:8080/api/contact/get-by-zip-code/77000
* Type of request: GET


Response body:
* if there are contacts with provided zip code

```
[
    {
        "id": 1,
        "fullName": "Ahmet Bajric",
        "dateOfBirth": "1994-11-05T00:00:00.000+00:00",
        "address": {
            "id": 1,
            "city": "Bihac",
            "zipCode": "77000"
        }
    }
]
```

Response code 
 * HTTP STATUS 200 (OK)
 
* if there are no address with provided zip code

Response body

```

```

Response code 
 * HTTP STATUS 204 (No Content)