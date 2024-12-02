# 설명
- EKS CI/CD 연습

<br/>

# 구조
- DB : AWS RDS, MySQL
- 이미지 저장소 : Docker HUB
- 배포 도구 : Github Action
- 서버 : AWS ECS

<br/>

# 실행 가이드
### windows cmd에서 실행하기
```bash
# 환경변수 설정
set RDS_USER=유저명
set RDS_PASSWORD=패스워드값

# 환경변수 설정 잘 됐는지 확인
echo %RDS_USER%
echo %RDS_PASSWORD%

# 프로젝트 빌드
gradlew clean build

# -D 옵션으로 환경변수 설정
java -jar -DRDS_USER=유저명 -DRDS_PASSWORD=패스워드 build/libs/public-cloud-exam-2024-0.0.1-SNAPSHOT.jar
```
### Dockerfile 이용해서 컨테이너로 실행하기
1. docker desktop 실행
2. 프로젝트 빌드
    - 프로젝트루트/build/libs에 jar 파일이 잘 생성됐는지 확인
   ```bash
   # 환경변수 설정
   set RDS_USER=유저명
   set RDS_PASSWORD=패스워드값
   
   # 환경변수 설정 잘 됐는지 확인
   echo %RDS_USER%
   echo %RDS_PASSWORD%
   
   # 프로젝트 빌드
   gradlew clean build
   ```
3. Dockerfile로 image build 및 컨테이너 띄우기
   프로젝트 루트에서 수행
   ```bash
   # image build
   docker buildx build --tag test1:latest .
   
   # 빌드된 이미지 확인
   # test1:latest 이미지가 생긴 것을 확인할 수 있다.
   docker images
   
   # 컨테이너 띄우기
   docker run -e RDS_USER=유저명 -e RDS_PASSWORD=패스워드 -p 8080:8080 test1:latest
   ```

4. (문제있을 경우) 컨테이너 로그 확인
   ```bash
   docker logs 컨테이너이름또는ID
   ```

### Docker HUB 로부터 pull 받아서 컨테이너로 실행하기
```bash
docker run -d -p 원하는포트:8080 -e RDS_USER=유저명 -e RDS_PASSWORD=패스워드 kiel0103/eks-prac-2024:태그
```
