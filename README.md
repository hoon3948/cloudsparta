![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![mySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![aws](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![DOCKER](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

# CH 4 클라우드_아키텍처 설계 & 배포
___
## LV 0 - 요금 폭탄 방지 AWS Budget 설정
설정 완료된 AWS Budgets 화면
![img.png](img.png)
![img_6.png](img_6.png)

<details>
<summary><font color="#f08080 red">실습 후 요금 관리</font></summary>

🌟실습 끝났을 때 비용 안 나가게 하는 법 (중요)

실습 끝나면 이 2개만 삭제하세요

1️⃣ Amazon EC2 인스턴스 Terminate<br>
2️⃣ Amazon RDS DB 인스턴스 Delete

⚠️ AWS 실습에서 가장 많이 터지는 요금 사고

1️⃣ RDS 안 지우고 방치 (가장 흔함)<br>
2️⃣ NAT Gateway 생성 (시간당 요금)<br>
3️⃣ Elastic IP 미사용 상태
</details>

___
## LV 1 - 네트워크 구축 및 핵심 기능 배포
### 1. 설정 완료된 EC2의 퍼블릭 IP: `43.202.55.128`
### 2. [상태 검증 링크](http://43.202.55.128:8080/actuator/health)<br>
![img_3.png](img_3.png)
### 3. [로컬 상태 검증 링크](http://localhost:8080/actuator/health)

<details>
<summary>로컬에서 상태 검증 JSON</summary>

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
</details>

___
## LV 2 - DB 분리 및 보안 연결하기
### 1. Actuator Info 엔드포인트 URL
[확인용 URL](http://43.202.55.128:8080/actuator/info)
![img_2.png](img_2.png)
### 2. RDS 보안 그룹 스크린샷
![img_5.png](img_5.png)
___

## LV 3 - 프로필 사진 기능 추가와 권한 관리
### 1. 발급받은 Presigned URL 1개와 해당 URL의 만료 시간
2026년 3월 18일 11시 52분에 Presigned URL 만료예정 <br>
[Presigned URL](https://cloud-health-taehoon-files.s3.ap-northeast-2.amazonaws.com/uploads/ee8e057f-2cd0-470f-af47-f3a0b4a7ecef_%EB%8F%84%EB%9D%BC.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260311T025152Z&X-Amz-SignedHeaders=host&X-Amz-Credential=AKIA2OG7PDLV7BSASE4F%2F20260311%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=4ac510fc44dd881e7033917edcc78218e5baa3c9c621f21c30ff68e525c38cf4)

___

## LV 4 - Docker & CI/CD 파이프라인 구축
### 1. Github Actions 성공 이미지
![img_7.png](img_7.png)

### 2. EC2 터미널 이미지
![img_8.png](img_8.png)
___

## LV 5 - 고가용성 아키텍처와 보안 도메인 연결 (ALB + ASG + HTTPS)
### 1. HTTPS 적용된 도메인 URL
### 2. Target Group(대상 그룹) 이미지