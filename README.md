___
### LV 0
설정 완료된 AWS Budgets 화면
![img.png](img.png)
___
### LV 1

상태 검증 `http://localhost:8080/actuator/health`
```json
{
    "components": {
        "db": {
            "details": {
                "database": "H2",
                "validationQuery": "isValid()"
            },
            "status": "UP"
        },
        "diskSpace": {
            "details": {
                "total": 510938107904,
                "free": 225863667712,
                "threshold": 10485760,
                "path": "C:\\Users\\1\\Desktop\\sparta\\cloudsparta\\.",
                "exists": true
            },
            "status": "UP"
        },
        "livenessState": {
            "status": "UP"
        },
        "ping": {
            "status": "UP"
        },
        "readinessState": {
            "status": "UP"
        },
        "ssl": {
            "details": {
                "expiringChains": [],
                "invalidChains": [],
                "validChains": []
            },
            "status": "UP"
        }
    },
    "groups": [
        "liveness",
        "readiness"
    ],
    "status": "UP"
}
```
___