# Hospital Management Staff System

Hospital Management Staff System is created for hospital staff where they can login and signup. Apart from that they can add the details of patient and fetch the required details.

Also a close attempt is made to fully cover the edge case scenarios for the problem statement.

Let's move to point. 

Please follow below steps to run the project:

1. Clone the git repository.

2. Open it in Eclipse/Intellij

3. Make sure Mysql server is running. (Mysql Workbench should be started)

4. Configure the application.properties file accordingly

5. Make a database schema with name hospital in Mysql Workbench.

6. Run the project by selecting Run as Java Application.

After the project is successfully run. Open Postman and test the following apis.


### SignUp User [POST]

URL: http://localhost:8080/hospital/user/signup 

Payload

```
{
  "name":"Amit",
  
  "userName":"amit",
  
  "password":"123454",
}
```

Expected Response 
```
{
    "data": {
        "id": 7,
        "name": "Amit",
        "userName": "amit",
        "password": "123454"
    },
    "message": "Successfully added data!",
    "status": 201
}
```
### Login User [POST]

http://localhost:8080/hospital/user/login

```
{
    "userName":"amit",
    "password":"123454"
}
```
Expected Response
```
{
    "data": null,
    "message": "User Logged In Successfully",
    "status": 200
}
```

### Assumptions
Hospital Staff will add the room and doctor details before creating patient. If user tried to add details before that they bound to see expected erros in response.

### Add Doctor [POST]

URL: http://localhost:8080/hospital/doctor

Payload
```
{
    "doctorRegistrationNumber":"123433",
    "name":"John",
    "specialization":"Surgeon"
}
```

Expected Response

```
{
    "data": {
        "doctorRegistrationNumber": "123433",
        "name": "John",
        "specialization": "Surgeon"
    },
    "message": "Successfully added data!",
    "status": 201
}
```

### Add Room [POST]

URL : http://localhost:8080/hospital/room

Payload
```
{
    "roomNumber":"22",
    "capacity":2,
    "availability":true
}
```
Expected Repsonse 
```
{
    "data": {
        "roomNumber": "22",
        "capacity": 2,
        "availability": true
    },
    "message": "Successfully added data!",
    "status": 201
}
```

Now we can add the patients details

### Add Patient[Post]
URL : http://localhost:8080/hospital/patient

Payload
```
{
    "name": "John Doe",
    "age": 35,
    "room": {
    "roomNumber":"22",
    "capacity":2,
    "availability":true
    },
    "doctor": {
    "doctorRegistrationNumber":"123433",
    "name":"John",
    "specialization":"Surgeon"
    },
    "admitInfo": {
    "admitDate": "2023-06-30",
    "expenses": 2500.00,
    "status": "admitted"
  }
}
```

Expected Response  

```
{
    "data": {
        "id": 10,
        "name": "John Doe",
        "age": 35,
        "room": {
            "roomNumber": "22",
            "capacity": 2,
            "availability": true
        },
        "doctor": {
            "doctorRegistrationNumber": "123433",
            "name": "John",
            "specialization": "Surgeon"
        },
        "admitInfo": {
            "id": 10,
            "admitDate": "2023-06-30",
            "expenses": 2500.0,
            "status": "admitted"
        }
    },
    "message": "Successfully added data!",
    "status": 201
}
```

### Get All Patients Details [GET]

URL : http://localhost:8080/hospital/patient/all

Expected Response
```
{
    "data": [
        {
            "id": 2,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 2,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 3,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 3,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 4,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 4,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 5,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 5,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 6,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 6,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 7,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 7,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "DISCHARGED"
            }
        },
        {
            "id": 8,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 8,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        },
        {
            "id": 9,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 9,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        },
        {
            "id": 10,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 10,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        }
    ],
    "message": "Successfully retrieved data!",
    "status": 200
}
```

### Fetch All Patient Details Who Are Admitted[GET]

URL: http://localhost:8080/hospital/patient/all/admitted
```
{
    "data": [
        {
            "id": 8,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 8,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        },
        {
            "id": 9,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 9,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        },
        {
            "id": 10,
            "name": "John Doe",
            "age": 35,
            "room": {
                "roomNumber": "22",
                "capacity": 2,
                "availability": true
            },
            "doctor": {
                "doctorRegistrationNumber": "123433",
                "name": "John",
                "specialization": "Surgeon"
            },
            "admitInfo": {
                "id": 10,
                "admitDate": "2023-06-30",
                "expenses": 2500.0,
                "status": "admitted"
            }
        }
    ],
    "message": "Successfully retrieved data!",
    "status": 200
}
```
### Discharge Patient From Hospital [PUT]

URL : http://localhost:8080/hospital/patient/discharge/8

Expected Response
```
{
    "data": {
        "id": 8,
        "name": "John Doe",
        "age": 35,
        "room": {
            "roomNumber": "22",
            "capacity": 2,
            "availability": true
        },
        "doctor": {
            "doctorRegistrationNumber": "123433",
            "name": "John",
            "specialization": "Surgeon"
        },
        "admitInfo": {
            "id": 8,
            "admitDate": "2023-06-30",
            "expenses": 2500.0,
            "status": "DISCHARGED"
        }
    },
    "message": "Patient Discharged Successfully",
    "status": 200
}
```
