이번 포스팅에서는 AWS의 `EC2`를 이용한 `Spring Boot` 서버 배포 방법을 글로 정리해보겠습니다.

우선, 서버를 왜 개인PC를 활용한 `On-premises` 환경으로 배포하지 않고 `AWS` 환경을 사용하는지에 대해서 정리해보겠습니다. 

`On-premises` 방법을 채택한다면, `개인 pc` 혹은 `회사용 서버 pc` 를 이용하게 될 텐데요. 이러한 경우, 서버 pc는 365일 24시간 켜져 있어야 합니다. 서버 운영자는 pc 설정이 자유롭지만 관리 또한 운영자의 몫입니다. 

서버를 확장하기 위해선 pc를 구매하고, `임시적인 서버 확장`이었다면 pc를 구매했다가 보관하거나 중고로 판매해야 하죠.. 서버 담당자가 신경써야 할 부분이 상당합니다.

반면에 AWS를 비롯한 `Cloud Service`는 설정에 따라 서버 담당자가 관리해야 하는 부분을 양도할 수 있습니다. `책임을 분리`할 수 있는 것이죠. 원한다면 간단한 설정 변경과 과금으로 `스케일 업` 혹은 `스케일 아웃`이 가능합니다. 일시적인 트래픽 밀집을 대비할 수 있는 것입니다.

![출처) https://www.redhat.com/ko/topics/cloud-computing/iaas-vs-paas-vs-saas](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/서버 배포 - ec2 기본 세팅/image.png)

저는 위와 같은 이유 중, 클라우드 서비스의 서버와 네트워크 관리 책임을 전가할 수 있는 `AWS EC2` 를 선택하게 되었습니다.

# 🐳 EC2 배포
저희 러닝하이 팀은 현재 `Spring Boot 3.2.3` 버전으로 개발을 진행해왔습니다. 프론트엔드 분들께서 서버를 테스트해볼 수 있도록 개발 서버도 배포가 필요했습니다. 

**`Spring Boot 프로젝트`**를 서버에 옮기는 방법은 **두 가지**가 있습니다.

1. `jar`파일로 빌드를 진행하고 `jar`파일을 배포된 서버에 전달
2. 배포된 서버에 `git` 설치 후 프로젝트 `clone`

그 중 저는 더 간간한 `jar`파일을 이용한 프로젝트 전달 방법을 사용하겠습니다.

# 📒 References
- [[Cloud Service - Iaas, Paas, Saas 사진 출처]](https://www.redhat.com/ko/topics/cloud-computing/iaas-vs-paas-vs-saas)