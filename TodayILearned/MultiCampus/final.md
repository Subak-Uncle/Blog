---
layout: single
title: "[멀캠] 파이널 팀 프로젝트"

categories: Web
tags: [web, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: ture
date: 2023-04-05
last_modified_at: 2023-04-05
sidebar:
  nav: "docs"
---





## [참고 사이트]

* [템플릿 구매 사이트](https://www.mangoboard.net/MangoTemplateAll.do)

* [노션노트 프로젝트](https://www.notion.so/Getting-f2a8f1ac6dea41f79d60b318f7c0e41a)

* [아이콘](https://www.flaticon.com/kr/free-icon/running_9999543)

* [html 템플릿](https://moonex.ibthemespro.com/#blog)

* [ppt템플릿](https://www.canva.com/ko_kr/)

* [얼굴인식](https://opencv.org/opencv-face-recognition/)

* [페이지 색감](colorTool)

* [파일 무료 변환 사이트](https://abcdpdf.com/ko/?gclid=CjwKCAjwscGjBhAXEiwAswQqNNJWgdLFakLhs_KSPnHL5X__mptriSyUN8ay2Lzc-RM92eRg50H6PRoCoj8QAvD_BwE)

* [개발자 블로그](https://80000coding.oopy.io/)

* [깃허브 액션 관련 글](https://velog.io/@adam2/GitHub-Actions-%EB%A1%9C-%ED%92%80%EB%A6%AC%ED%80%98%EC%8A%A4%ED%8A%B8-test-%EA%B2%80%EC%A6%9D%ED%95%98%EA%B8%B0)

  

ERD Diagram - erd cloud

## 주제후보

* 넷플릭스 형태의 유튜브 재조합!
  * 양질의 컨텐츠 관리
* 공부한 내용들을 정리한 공부 블로그 + 애니매이션!
  * 도트맵으로 성장성 표현!
  * 캐릭터 생성 - 성장에 따라 체크셔츠 색깔 변화
* 주차장 자리 체크 웹
  * 요금 결제 - 우버처럼 등록된 카드로 결제!
  * 주차 위치 확인
    * 카메라 위치 / 거울을 활용
  * 자리 났을 때 알림
* (탄소 배출량 감소 초점) 쇼핑몰
  * 친환경 제품 판매
  * 업자와 소비자 중개 웹사이트

* 스터디 그룹 매칭 플랫폼
  * 관심사에 따른 스터디 그룹 매칭
  * 게시판 기능
  * 추가 기능
  * IT 직군으로 고정하고 모각코, 프로젝트 팀플원 모집
  * [관련 사이트 목록]
    * [https://www.wishket.com/postscript/?referer_type=2010117787&utm_source=google&utm_medium=cpc&utm_campaign=19241582349&utm_content=%EC%82%AC%EC%9D%B4%EB%93%9C%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8&utm_term=&gclid=Cj0KCQjwla-hBhD7ARIsAM9tQKtELdDrEGBZahB8qGflLqDZZPlqxmd-hQWElDTdnl1wZQldF4l3k8IaAuqBEALw_wcB
  
* 인터뷰 대비 플랫폼
  * 직무 관련 인터뷰 서비스
  * 문서 협업 툴 (지라?) 제작
  * [AI면접 사이트](https://front.viewinter.ai/index.html#/introduce)
  
* 동물입양 사이트
  * 입양 절차를 까다롭게 해서 입양 사이트





## 내비게이션 바

~~~html
<div class="d-flex flex-column flex-shrink-0 bg-body-tertiary" style="width: 4.5rem;">
    <a href="/" class="d-block p-3 link-body-emphasis text-decoration-none" title="Icon-only" data-bs-toggle="tooltip" data-bs-placement="right">
      <svg class="bi pe-none" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="visually-hidden">Icon-only</span>
    </a>
    <ul class="nav nav-pills nav-flush flex-column mb-auto text-center">
      <li class="nav-item">
        <a href="#" class="nav-link active py-3 border-bottom rounded-0" aria-current="page" title="Home" data-bs-toggle="tooltip" data-bs-placement="right">
          <svg class="bi pe-none" width="24" height="24" role="img" aria-label="Home"><use xlink:href="#home"/></svg>
        </a>
      </li>
    </ul>
    <div class="dropdown border-top">
      <a href="#" class="d-flex align-items-center justify-content-center p-3 link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="https://github.com/mdo.png" alt="mdo" width="24" height="24" class="rounded-circle">
      </a>
      <ul class="dropdown-menu text-small shadow">
        <li><a class="dropdown-item" href="#">New project...</a></li>
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#">Sign out</a></li>
      </ul>
    </div>
  </div>

~~~



~~~html
import { Link } from 'react-router-dom';

<div className='d-flex flex-column flex-shrink-0 bg-body-tertiary' style={{ width: '4.5rem' }}>
  <Link to='/' className='d-block p-3 link-body-emphasis text-decoration-none' title='Icon-only' data-bs-toggle='tooltip' data-bs-placement='right'>
    <svg className='bi pe-none' width='40' height='32'><use xlinkHref='#bootstrap'/></svg>
    <span className='visually-hidden'>Icon-only</span>
  </Link>
  <ul className='nav nav-pills nav-flush flex-column mb-auto text-center'>
    <li className='nav-item'>
      <Link to='#' className='nav-link active py-3 border-bottom rounded-0' aria-current='page' title='Home' data-bs-toggle='tooltip' data-bs-placement='right'>
        <svg className='bi pe-none' width='24' height='24' role='img' aria-label='Home'><use xlinkHref='#home'/></svg>
      </Link>
    </li>
    <li>
      <Link to='#' className='nav-link py-3 border-bottom rounded-0' title='Dashboard' data-bs-toggle='tooltip' data-bs-placement='right'>
        <svg className='bi pe-none' width='24' height='24' role='img' aria-label='Dashboard'><use xlinkHref='#speedometer2'/></svg>
      </Link>
    </li>
    <li>
      <Link to='#' className='nav-link py-3 border-bottom rounded-0' title='Orders' data-bs-toggle='tooltip' data-bs-placement='right'>
        <svg className='bi pe-none' width='24' height='24' role='img' aria-label='Orders'><use xlinkHref='#table'/></svg>
      </Link>
    </li>
    <li>
      <Link to='#' className='nav-link py-3 border-bottom rounded-0' title='Products' data-bs-toggle='tooltip' data-bs-placement='right'>
        <svg className='bi pe-none' width='24' height='24' role='img' aria-label='Products'><use xlinkHref='#grid'/></svg>
      </Link>
    </li>
    <li>
      <Link to='#' className='nav-link py-3 border-bottom rounded-0' title='Customers' data-bs-toggle='tooltip' data-bs-placement='right'>
        <svg className='bi pe-none' width='24' height='24' role='img' aria-label='Customers'><use xlinkHref='#people-circle'/></svg>
      </Link>
    </li>
  </ul>
  <div className='dropdown border-top'>
    <Link to='#' className='d-flex align-items-center justify-content-center p-3 link-body-emphasis text-decoration-none dropdown-toggle' data-bs-toggle='dropdown' aria-expanded='false'>
      <img src='https://github.com/mdo.png' alt='mdo' width='24' height='24' className='rounded-circle' />
    </Link>
    <ul className='dropdown-menu text-small shadow'>
      <li><Link to='#' className='dropdown-item'>New project...</Link></li>
      <li><Link to='#' className='dropdown-item'>Settings</Link></li>
      <li><Link to='#' className='dropdown-item'>

~~~

~~~jsx
import { Nav, Dropdown } from 'react-bootstrap';

<Nav className="flex-column flex-shrink-0 bg-body-tertiary" style={{ width: '4.5rem' }}>
  <Nav.Link href="/" className="d-block p-3 link-body-emphasis text-decoration-none" title="Icon-only" data-bs-toggle="tooltip" data-bs-placement="right">
    <svg className="bi pe-none" width="40" height="32"><use xlinkHref="#bootstrap"/></svg>
    <span className="visually-hidden">Icon-only</span>
  </Nav.Link>
  <Nav className="nav-pills nav-flush flex-column mb-auto text-center">
    <Nav.Item>
      <Nav.Link href="#" className="nav-link active py-3 border-bottom rounded-0" aria-current="page" title="Home" data-bs-toggle="tooltip" data-bs-placement="right">
        <svg className="bi pe-none" width="24" height="24" role="img" aria-label="Home"><use xlinkHref="#home"/></svg>
      </Nav.Link>
    </Nav.Item>
  </Nav>
  <Dropdown className="border-top">
    <Dropdown.Toggle className="d-flex align-items-center justify-content-center p-3 link-body-emphasis text-decoration-none" data-bs-toggle="dropdown" aria-expanded="false">
      <img src="https://github.com/mdo.png" alt="mdo" width="24" height="24" className="rounded-circle" />
    </Dropdown.Toggle>
    <Dropdown.Menu className="text-small shadow">
      <Dropdown.Item href="#">New project...</Dropdown.Item>
      <Dropdown.Item href="#">Settings</Dropdown.Item>
      <Dropdown.Item href="#">Profile</Dropdown.Item>
      <Dropdown.Divider />
      <Dropdown.Item href="#">Sign out</Dropdown.Item>
    </Dropdown.Menu>
  </Dropdown>
</Nav>
~~~





~~~html

  <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-body-tertiary" style="width: 380px;">
    <a href="/" class="d-flex align-items-center flex-shrink-0 p-3 link-body-emphasis text-decoration-none border-bottom">
      <svg class="bi pe-none me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-5 fw-semibold">List group</span>
    </a>
    <div class="list-group list-group-flush border-bottom scrollarea">
      <a href="#" class="list-group-item list-group-item-action active py-3 lh-sm" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small>Wed</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Tues</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Mon</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>

      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Wed</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Tues</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Mon</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Wed</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Tues</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Mon</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Wed</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Tues</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
      <a href="#" class="list-group-item list-group-item-action py-3 lh-sm">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">List group item heading</strong>
          <small class="text-body-secondary">Mon</small>
        </div>
        <div class="col-10 mb-1 small">Some placeholder content in a paragraph below the heading and date.</div>
      </a>
    </div>
  </div>
~~~



# Routes

~~~js
import { createWebHistory, createRouter } from 'vue-router'

// 홈
import Home from '../views/Home.vue'

// 코스
import Course from '../views/Course.vue'
import CourseMain from '../components/course/Course.vue'
import CourseList from '../components/course/course/List.vue'
import CourseDetail from '../components/course/course/Detail.vue'
import CourseDetailRecord from '../components/course/course/DetailRecord.vue'
import CourseDetailInfo from '../components/course/course/DetailInfo.vue'
import CourseDetailComment from '../components/course/course/DetailComment.vue'
import CourseDetailBadge from '../components/course/course/DetailBadge.vue'
// import CourseBook from '../components/course/Book.vue'
// import CourseBookList from '../components/course/book/List.vue'
// import CourseBookDetail from '../components/course/book/Detail.vue'
// import CourseBookDetailInfo from '../components/course/book/DetailInfo.vue'
// import CourseBookDetailChallenge from '../components/course/book/DetailChallenge.vue'
// import CourseBookDetailComment from '../components/course/book/DetailComment.vue'
// import CourseBookDetailBadge from '../components/course/book/DetailBadge.vue'
// import UserCourseBookDetail from '../components/course/book/user/Detail.vue'
// import UserCourseBookDetailInfo from '../components/course/book/user/DetailInfo.vue'
// import UserCourseBookDetailChallenge from '../components/course/book/user/DetailChallenge.vue'
// import UserCourseBookDetailComment from '../components/course/book/user/DetailComment.vue'
// import UserCourseBookDetailBadge from '../components/course/book/user/DetailBadge.vue'
// import CourseAnalyze from '../components/course/Analyze.vue'
import CourseMy from '../components/course/My.vue'
import CourseMyGpx from '../components/course/MyGpx.vue'
// import CourseHistory from '../components/course/History.vue'
// import CourseTheme from '../components/course/Theme.vue'
// import CourseThemeMain from '../components/course/theme/Main.vue'
// import CourseThemeList from '../components/course/theme/List.vue'

// 마이트랭글
import MyTranggle from '../views/MyTranggle.vue'
// import MyTranggleMyInfo from '../components/mytranggle/MyInfo.vue'
// import MyTranggleMyFriend from '../components/mytranggle/MyFriend.vue'
// import MyTranggleMyFriendDetails from '../components/mytranggle/MyfriendDetails.vue'
// import MyTranggleAnotherRecord from '../components/mytranggle/AnotherRecord.vue'
// import MyTranggleBadgeSearch from '../components/mytranggle/BadgeSearch.vue'
// import MyTranggleBadgeDetails from '../components/mytranggle/BadgeDetails.vue'
// import MyTranggleBadgeDetails360 from '../components/mytranggle/BadgeDetails360.vue'
// import MyTranggleMyAcceptFriend from '../components/mytranggle/MyAcceptFriend.vue'
// import MyTranggleMyAcceptFriendInvited from '../components/mytranggle/MyAcceptFriendInvited.vue'
// import MyTranggleMyAcceptFriendInvite from '../components/mytranggle/MyAcceptFriendInvite.vue'
// import MyTranggleMyMessage from '../components/mytranggle/MyMessage.vue'
// import MyTranggleMessageChat from '../components/mytranggle/MyMessageChat.vue'
// import MyTranggleMyMessageSend from '../components/mytranggle/MyMessageSend.vue'
// import MyTranggleMyBadgeList from '../components/mytranggle/MyBadgeList.vue'
// import MyTranWallet from '../components/mytranggle/MyTranWallet.vue'
import MyTrangConf from '../components/mytranggle/MyTrangConf.vue'

// 나의 활동
// import Activity from '../views/Activity.vue'
// import ActivityMain from '../components/activity/ActivityMain.vue'
// import ActivityComp from '../components/activity/ActivityComp.vue'
// import ActivityCompDetail from '../components/activity/ActivityCompDetail.vue'

// 미션
// import Mission from '../views/Mission.vue'
// import MissionMain from '../components/mission/MissionMain.vue'
// // import MyMission from '../components/mission/MyMission.vue'
// // import MyMissionSearch from '../components/mission/MyMissionSearch.vue'
// // import MissionOpened from '../components/mission/MissionOpened.vue'
// // import MissionConfig from '../components/mission/MissionConfig.vue'
// // import MyMission from '../components/mission/MyMission.vue'
// // import MyMissionSearch from '../components/mission/MyMissionSearch.vue'
// import MissionCreate from '../components/mission/MissionCreate.vue'
// // import MissionModify from '../components/mission/MissionModify.vue'
// import MissionSearch from '../components/mission/MissionSearch.vue'
// import MissionView from '../components/mission/MissionView.vue'
// import MissionJoin from '../components/mission/MissionJoin.vue'
// // import MissionConfig from '../components/mission/MissionConfig.vue'
// import MissionAdmin from '../components/mission/manager/MissionAdmin.vue'
// import MissionManagerStatus from '../components/mission/manager/MissionManagerStatus.vue'
// import MissionManagerParticipant from '../components/mission/manager/MissionManagerParticipant.vue'
// import MissionManagerRecord from '../components/mission/manager/MissionManagerRecord.vue'
// import MissionManagerSurvey from '../components/mission/manager/MissionManagerSurvey.vue'
// import MissionManagerPopup from '../components/mission/manager/MissionManagerPopup.vue'
// import MissionManagerGroup from '../components/mission/manager/MissionManagerGroup.vue'
// import MissionManagerIntroduction from '../components/mission/manager/MissionManagerIntroduction.vue'
// import MissionManagerAdmin from '../components/mission/manager/MissionManagerAdmin.vue'

// 클럽
// import Club from '../views/Club.vue'
// import ClubMain from '../components/club/ClubMain.vue'
// import ClubSearch from '../components/club/ClubSearch.vue'
// import ClubRecruitment from '../components/club/ClubRecruitment.vue'
// import ClubNew from '../components/club/ClubNew.vue'
// import ClubCreate from '../components/club/ClubCreate.vue'
// import MyClub from '../components/club/ClubMyClub.vue'
// import ClubDetail from '../components/club/details/main/Main.vue'
// import ClubDetailRecirect from '../components/club/ClubDetailRecirect.vue'
// import ClubDetailCalendar from '../components/club/details/calendar/Main.vue' // 클럽 - 일정
// import ClubDetailMember from '../components/club/details/member/Main.vue' // 클럽 - 멤버
// import ClubDetailRank from '../components/club/details/rank/Main.vue' // 클럽 - 랭크
// import ClubDetailNotice from '../components/club/details/notice/Main.vue' // 클럽 - 공지 메인
// import ClubDetailNoticeWrite from '../components/club/details/notice/Write.vue' // 클럽 - 공지 작성
// import ClubDetailNoticeRead from '../components/club/details/notice/Read.vue' // 클럽 - 공지 읽기
// import ClubDetailNoticeModify from '../components/club/details/notice/Modify.vue' // 클럽 - 공지 수정
// import ClubDetailMeet from '../components/club/details/meet/Main.vue' // 클럽 - 모임
// import ClubDetailMeetCreate from '../components/club/details/meet/Create.vue' // 클럽 - 모임 개설
// import ClubDetailMeetRead from '../components/club/details/meet/Read.vue' // 클럽 - 모임 개설
// import ClubDetailMeetModify from '../components/club/details/meet/Modify.vue' // 클럽 - 모임 개설
// import ClubDetailBoard from '../components/club/details/board/Main.vue' // 클럽 - 자유 게시판
// import ClubDetailBoardWrite from '../components/club/details/board/Write.vue' // 클럽 - 게시판 작성
// import ClubDetailBoardRead from '../components/club/details/board/Read.vue' // 클럽 - 게시판 읽기
// import ClubDetailBoardModify from '../components/club/details/board/Modify.vue' // 클럽 - 게시판 수정
// import ClubManage from '../components/club/manage/Intro.vue' // 클럽 - 클럽관리
// import ClubManageMember from '../components/club/manage/Member.vue' // 클럽 - 클럽관리 멤버
// import ClubManageBoard from '../components/club/manage/Board.vue' // 클럽 - 클럽관리 게시판

// 스토리
// import Story from '../views/Story.vue'
// import StoryMain from '../components/story/Main.vue'
// import StoryList from '../components/story/List.vue'
// import StoryDetail from '../components/story/Detail.vue'
// import MyStory from '../components/story/My.vue'
// import WriteStory from '../components/story/Write.vue'

// 회원
import Login from '../views/Login.vue'
import Join from '../components/member/Join.vue'
import JoinComplete from '../components/member/JoinComplete.vue'
import FindId from '../components/member/FindId.vue'
import ChangePassword from '../components/member/ChangePassword.vue'
import Authentication from '../components/member/Authentication.vue'

// 트랭글 NOW
// import TranggleNow from '../views/TranggleNow.vue'

// 페이스북 로그인 이동
import Loding from '../views/Loding.vue'

// 고객지원
// import Support from '../views/Support.vue'
// import Notice from '../components/support/Notice.vue'
// import NoticeDetail from '../components/support/NoticeDetail.vue'
// import Information from '../components/support/Information.vue'
// import Inquire from '../components/support/Inquire.vue'
// import InquireRegist from '../components/support/InquireRegist.vue'
// import InquireDetail from '../components/support/InquireDetail.vue'
// import Recommended from '../components/support/Recommended.vue'
// import Instruction from '../components/support/Instruction.vue'
// import InstructionDetail from '../components/support/InstructionDetail.vue'

// 정책 및 약관
import Policy from '../views/Policy.vue'
import Terms from '../components/policy/Terms.vue'
import PersonalInformation from '../components/policy/PersonalInformation.vue'
import TranggleTalk from '../components/policy/TranggleTalk.vue'
import GeoData from '../components/policy/GeoData.vue'
import TrangInfo from '../components/policy/TrangInfo.vue'
import TermProvision from '../components/policy/TermProvision.vue'
import TermMission from '../components/policy/TermMission.vue'

// import store from '../store/index'

// import Control from '../views/Control.vue'
// import MissonList from '../components/admin/MissonList.vue'
// import MissonSearch from '../components/admin/MissonSearch.vue'
// import ControlCourseList from '../components/admin/CourseList.vue'
// import CourseSearch from '../components/admin/CourseSearch.vue'
// import ThemaList from '../components/admin/ThemaList.vue'
// import ThemaSearch from '../components/admin/ThemaSearch.vue'
// import ThemaDetail from '../components/admin/ThemaDetail.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  // {
  //   path: '/control',
  //   component: Control,
  //   children: [
  //     {
  //       path: 'missonlist',
  //       component: MissonList
  //     },
  //     {
  //       path: 'missonsearch',
  //       component: MissonSearch
  //     },
  //     {
  //       path: 'courselist',
  //       component: ControlCourseList
  //     },
  //     {
  //       path: 'coursesearch',
  //       component: CourseSearch
  //     },
  //     {
  //       path: 'themalist',
  //       component: ThemaList
  //     },
  //     {
  //       path: 'themasearch',
  //       component: ThemaSearch
  //     },
  //     {
  //       path: 'themadetail/:no',
  //       component: ThemaDetail
  //     }
  //   ]
  // },
  // {
  //   path: '/support',
  //   component: Support,
  //   children: [
  //     {
  //       path: 'notice',
  //       component: Notice
  //     },
  //     {
  //       path: 'notice/:no',
  //       component: NoticeDetail
  //     },
  //     {
  //       path: 'information',
  //       component: Information
  //     },
  //     {
  //       path: 'inquire',
  //       component: Inquire
  //     },
  //     {
  //       path: 'regist',
  //       component: InquireRegist
  //     },
  //     {
  //       path: 'inquire/:no',
  //       component: InquireDetail
  //     },
  //     {
  //       path: 'recommended',
  //       component: Recommended
  //     },
  //     {
  //       path: 'instruction',
  //       component: Instruction
  //     },
  //     {
  //       path: 'instruction/:page/:no',
  //       component: InstructionDetail
  //     }
  //   ]
  // },
  {
    path: '/policy',
    component: Policy,
    children: [
      {
        path: 'terms',
        component: Terms
      },
      {
        path: 'personalinformation',
        component: PersonalInformation
      },
      {
        path: 'tranggletalk',
        component: TranggleTalk
      },
      {
        path: 'geodata',
        component: GeoData
      },
      {
        path: 'tranginfo',
        component: TrangInfo
      },
      {
        path: 'termprovision',
        component: TermProvision
      },
      {
        path: 'termmission',
        component: TermMission
      }
    ]
  },
  {
    path: '/course',
    component: Course,
    children: [
      {
        path: '',
        component: CourseMain,
        children: [
          {
            path: '',
            component: CourseList
          },
          {
            path: ':id',
            component: CourseDetail,
            children: [
              {
                path: '',
                component: CourseDetailRecord
              },
              {
                path: 'info',
                component: CourseDetailInfo
              },
              {
                path: 'badge',
                component: CourseDetailBadge
              },
              {
                path: 'comment',
                component: CourseDetailComment
              }
            ]
          }
        ]
      },
      // {
      //   path: 'book',
      //   component: CourseBook,
      //   children: [
      //     {
      //       path: '',
      //       component: CourseBookList
      //     },
      //     {
      //       path: ':id',
      //       component: CourseBookDetail,
      //       children: [
      //         {
      //           path: '',
      //           component: CourseBookDetailInfo
      //         },
      //         {
      //           path: 'challenge',
      //           component: CourseBookDetailChallenge
      //         },
      //         {
      //           path: 'badge',
      //           component: CourseBookDetailBadge
      //         },
      //         {
      //           path: 'comment',
      //           component: CourseBookDetailComment
      //         }
      //       ]
      //     },
      //     {
      //       path: 'user/:id',
      //       component: UserCourseBookDetail,
      //       children: [
      //         {
      //           path: '',
      //           component: UserCourseBookDetailInfo
      //         },
      //         {
      //           path: 'challenge',
      //           component: UserCourseBookDetailChallenge
      //         },
      //         {
      //           path: 'badge',
      //           component: UserCourseBookDetailBadge
      //         },
      //         {
      //           path: 'comment',
      //           component: UserCourseBookDetailComment
      //         }
      //       ]
      //     }
      //   ]
      // },
      // {
      //   path: 'analyze',
      //   component: CourseAnalyze
      // },
      {
        path: 'my',
        component: CourseMy
      },
      {
        path: 'my/gpx',
        component: CourseMyGpx
      }
      // {
      //   path: 'history',
      //   component: CourseHistory
      // },
      // {
      //   path: 'theme',
      //   component: CourseTheme,
      //   children: [
      //     {
      //       path: '',
      //       component: CourseThemeMain
      //     },
      //     {
      //       path: ':id',
      //       component: CourseThemeList
      //     }
      //   ]
      // }
    ]
  },
  {
    path: '/mytranggle',
    component: MyTranggle,
    children: [
      // {
      //   path: 'myinfo',
      //   component: MyTranggleMyInfo
      // },
      // {
      //   path: 'myfriend',
      //   component: MyTranggleMyFriend
      // },
      // {
      //   path: 'friendInfo/:id',
      //   component: MyTranggleMyFriendDetails
      // },
      // {
      //   path: 'anotherrecord',
      //   component: MyTranggleAnotherRecord
      // },
      // {
      //   path: 'badgesearch',
      //   component: MyTranggleBadgeSearch
      // },
      // {
      //   path: 'badge/:badgeCode',
      //   component: MyTranggleBadgeDetails
      // },
      // {
      //   path: 'badgevideo/:badgeCode',
      //   component: MyTranggleBadgeDetails360
      // },
      // {
      //   path: 'myacceptfriend',
      //   component: MyTranggleMyAcceptFriend
      // },
      // {
      //   path: 'myacceptfriendinvited',
      //   component: MyTranggleMyAcceptFriendInvited
      // },
      // {
      //   path: 'myacceptfriendinvite',
      //   component: MyTranggleMyAcceptFriendInvite
      // },
      // {
      //   path: 'mymessage',
      //   component: MyTranggleMyMessage
      // },
      // {
      //   path: 'mymessage/:no',
      //   component: MyTranggleMessageChat
      // },
      // {
      //   path: 'messagesend',
      //   component: MyTranggleMyMessageSend
      // },
      // {
      //   path: 'mybadgelist',
      //   component: MyTranggleMyBadgeList
      // },
      // {
      //   path: 'mytranwallet',
      //   component: MyTranWallet
      // },
      {
        path: 'mytrangconf',
        component: MyTrangConf
      }
    ]
  },
  // {
  //   path: '/activity',
  //   component: Activity,
  //   children: [
  //     {
  //       path: 'main',
  //       component: ActivityMain
  //     },
  //     {
  //       path: 'comp',
  //       component: ActivityComp
  //     },
  //     {
  //       path: 'ActivityCompDetail/:no',
  //       component: ActivityCompDetail
  //     }
  //   ]
  // },
  // {
  //   path: '/mission',
  //   component: Mission,
  //   children: [
  //     {
  //       path: '',
  //       component: MissionMain
  //     },
  //     {
  //       path: 'search',
  //       component: MissionSearch,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'create',
  //       component: MissionCreate
  //     },
  //     {
  //       path: ':id',
  //       component: MissionView,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: ':id(\\d+)/notice',
  //       component: MissionView,
  //       props: {
  //         isNotice: true,
  //         isBoard: false
  //       }
  //     },
  //     {
  //       path: ':id(\\d+)/notice/:boardNo(\\d+)',
  //       component: MissionView,
  //       props: {
  //         isNotice: true,
  //         isBoard: false
  //       }
  //     },
  //     {
  //       path: ':id(\\d+)/board',
  //       component: MissionView,
  //       props: {
  //         isNotice: false,
  //         isBoard: true
  //       }
  //     },
  //     {
  //       path: ':id/board/:boardNo',
  //       component: MissionView,
  //       props: {
  //         isNotice: false,
  //         isBoard: true
  //       }
  //     },
  //     // {
  //     //   path: ':id/modify',
  //     //   component: MissionModify
  //     // },
  //     {
  //       name: 'missionJoin',
  //       path: ':id(\\d+)/join',
  //       component: MissionJoin,
  //       props: true
  //     },
  //     {
  //       path: ':id(\\d+)/admin',
  //       component: MissionAdmin
  //     },
  //     {
  //       path: ':id(\\d+)/managerStatus',
  //       component: MissionManagerStatus
  //     },
  //     {
  //       path: ':id(\\d+)/managerParticipant',
  //       component: MissionManagerParticipant
  //     },
  //     {
  //       path: ':id(\\d+)/managerRecord',
  //       component: MissionManagerRecord
  //     },
  //     {
  //       path: ':id(\\d+)/managerSurvey',
  //       component: MissionManagerSurvey
  //     },
  //     {
  //       path: ':id(\\d+)/managerGroup',
  //       component: MissionManagerGroup
  //     },
  //     {
  //       path: ':id(\\d+)/managerIntroduction',
  //       component: MissionManagerIntroduction
  //     },
  //     {
  //       path: ':id(\\d+)/managerAdmin',
  //       component: MissionManagerAdmin
  //     },
  //     {
  //       path: ':id(\\d+)/managerPopup',
  //       component: MissionManagerPopup
  //     }
  //   ]
  // },
  // {
  //   path: '/club',
  //   component: Club,
  //   children: [
  //     {
  //       path: '',
  //       component: ClubMain
  //     },
  //     {
  //       path: 'search',
  //       component: ClubSearch,
  //       beforeEnter: (to, from, next) => {
  //         console.log('search')
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'recruitment',
  //       component: ClubRecruitment,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'new',
  //       component: ClubNew,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'create',
  //       component: ClubCreate,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'myclub',
  //       component: MyClub
  //     },
  //     {
  //       path: 'manage',
  //       component: ClubManage
  //     },
  //     {
  //       path: 'managemember',
  //       component: ClubManageMember
  //     },
  //     {
  //       path: ':id(\\d+)',
  //       component: ClubDetail,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: ':id(\\d+)/member',
  //       component: ClubDetailMember
  //     },
  //     {
  //       path: ':id(\\d+)/calendar',
  //       component: ClubDetailCalendar
  //     },
  //     {
  //       path: ':id(\\d+)/rank',
  //       component: ClubDetailRank
  //     },
  //     // 클럽 - 공지
  //     {
  //       path: ':id(\\d+)/notice',
  //       component: ClubDetailNotice
  //     },
  //     {
  //       path: ':id(\\d+)/notice/write',
  //       component: ClubDetailNoticeWrite
  //     },
  //     {
  //       path: ':id(\\d+)/notice/:no(\\d+)',
  //       component: ClubDetailNoticeRead
  //     },
  //     {
  //       path: ':id(\\d+)/notice/:no(\\d+)/modify',
  //       component: ClubDetailNoticeModify
  //     },
  //     // 클럽 - 모임
  //     {
  //       path: ':id(\\d+)/meet',
  //       component: ClubDetailMeet
  //     },
  //     {
  //       path: ':id(\\d+)/meet/:no(\\d+)',
  //       component: ClubDetailMeetRead
  //     },
  //     {
  //       path: ':id(\\d+)/meet/:no(\\d+)/modify',
  //       component: ClubDetailMeetModify
  //     },
  //     {
  //       path: ':id(\\d+)/meet/write',
  //       component: ClubDetailMeetCreate
  //     },
  //     // 클럽 관리
  //     {
  //       path: ':id(\\d+)/manage',
  //       component: ClubManage
  //     },
  //     {
  //       path: ':id(\\d+)/manage/intro',
  //       component: ClubManage
  //     },
  //     {
  //       path: ':id(\\d+)/manage/board',
  //       component: ClubManageBoard
  //     },
  //     {
  //       path: ':id(\\d+)/manage/member',
  //       component: ClubManageMember
  //     },
  //     // 클럽 - 자유게시판
  //     {
  //       path: ':id(\\d+)/board/:basicNo(\\d+)',
  //       component: ClubDetailBoard
  //     },
  //     {
  //       path: ':id(\\d+)/board/:basicNo(\\d+)/:no(\\d+)',
  //       component: ClubDetailBoardRead
  //     },
  //     {
  //       path: ':id(\\d+)/board/:basicNo(\\d+)/:no(\\d+)/modify',
  //       component: ClubDetailBoardModify
  //     },
  //     {
  //       path: ':id(\\d+)/board/:basicNo(\\d+)/write',
  //       component: ClubDetailBoardWrite
  //     },
  //     {
  //       path: ':id',
  //       component: ClubDetailRecirect
  //     }
  //   ]
  // },
  // {
  //   path: '/story',
  //   component: Story,
  //   children: [
  //     {
  //       path: '',
  //       component: StoryMain
  //     },
  //     {
  //       path: 'list',
  //       component: StoryList,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         // store.state.Popup.isLoginPopupBackEvent = 0 // 취소시 뒤로가기
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'my',
  //       component: MyStory,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: ':id',
  //       component: StoryDetail,
  //       beforeEnter: (to, from, next) => {
  //         if (store.state.UserSet.isLogin === 'Y') {
  //           return next()
  //         }
  //         store.state.Popup.isLoginPopupBackEvent = 1 // 취소시 팝업만 off
  //         store.state.Popup.isOpenLoginPopup = true
  //       }
  //     },
  //     {
  //       path: 'write',
  //       component: WriteStory
  //       // beforeEnter: (to, from, next) => {
  //       //   if (store.state.UserSet.isLogin === 'Y') {
  //       //     return next()
  //       //   }
  //       //   store.state.Popup.isLoginPopupBackEvent = 0 // 취소시 뒤로가기
  //       //   store.state.Popup.isOpenLoginPopup = true
  //       // }
  //     },
  //     {
  //       path: 'write/:id',
  //       component: WriteStory
  //       // beforeEnter: (to, from, next) => {
  //       //   if (store.state.UserSet.isLogin === 'Y') {
  //       //     return next()
  //       //   }
  //       //   store.state.Popup.isLoginPopupBackEvent = 0 // 취소시 뒤로가기
  //       //   store.state.Popup.isOpenLoginPopup = true
  //       // }
  //     }
  //   ]
  // },
  // 로그인
  { path: '/login', component: Login },
  // 회원 가입
  { path: '/member/join', component: Join },
  // 회원 가입 완료
  { path: '/member/joinComplete', component: JoinComplete },
  // 아이디 찾기
  { path: '/member/find/id', component: FindId },
  // 비밀번호 재설정
  { path: '/member/change/pw', component: ChangePassword },
  // 본인인증
  { path: '/member/auth', component: Authentication },
  // 트랭글 NOW
  // { path: '/now', component: TranggleNow },
  // 페이스북 로그인 이동
  { path: '/Loding', component: Loding },
  // 없는 url 접근 캐치
  { path: '/:catchAll(.*)', component: () => import('../views/notFoundPage') }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
~~~



# Axios

~~~js
import axios from 'axios'
import store from '../store/index'
// import router from '../router'

const sessionId = localStorage.getItem('sessionID') ? localStorage.getItem('sessionID') : 'devsession_id'
// 개발용 api 분기처리
axios.defaults.baseURL = (location.href.includes('dev')) ? `//stage.tranggle.com/dev.html/${sessionId}/v2/` : '/v2/'

const axiosInstance = axios.create({
})

axiosInstance.interceptors.request.use(
  config => {
    // 개발환경일 경우 test파라미터 추가
    // if (location.href.includes('dev')) {
    //   config.params.test = 'Y'
    // }
    store.commit('Common/startSpinner')
    return config
  },
  error => {
    // alert('데이터를 불러오는데 실패하였습니다.\n새로고침을 해주세요.')
    store.commit('Common/endSpinner')
    return Promise.reject(error)
  }
)

axiosInstance.interceptors.response.use(
  response => {
    if (response.data.response.code === '1004') {
      store.state.UserSet.isLogin = 'N'
      // const data = { popupHeaderMessage: '', popupBodyMessage: '로그인 정보가 존재하지 않습니다.<br />로그인후 이용하시기 바랍니다.', link: '/login' }
      // store.commit('Popup/setMessagePopup', data)
      // store.commit('Popup/controlMessagePopup')
      if (location.href.includes('dev')) {
        localStorage.removeItem('sessionID')
      }
    }
    store.commit('Common/endSpinner')
    return response
  },
  error => {
    // alert('데이터를 불러오는데 실패하였습니다.\n새로고침을 해주세요.')
    store.commit('Common/endSpinner')
    return Promise.reject(error)
  }
)

// axios.defaults.baseURL = 'https://stage.tranggle.com/v2/'

export default axiosInstance

~~~



# App

~~~vue
<template>
  <div class="wrap" :class="pageClass()">
    <router-view></router-view>
    <!-- <DormantPopup v-if="isOpenDormantPopup" /> -->
    <CommonPopup />
  </div>
  <Spinner :loading="this.$store.state.Common.loadingStatus"/>
  <DormantPopup v-if="isOpenDormantPopup" />
</template>

<script>
import CommonPopup from '@/components/common/CommonPopup.vue'
import Spinner from '@/components/common/Spinner.vue'
import DormantPopup from '@/components/member/popup/DormantPopup.vue'

// import axios from 'axios'
import { mapState, mapActions } from 'vuex'
export default {
  name: 'App',
  components: {
    CommonPopup,
    Spinner,
    DormantPopup
  },
  computed: {
    ...mapState('UserSet', [
      'isOpenDormantPopup'
    ])
  },
  mounted () {
    this.loadGetToken()
  },
  methods: {
    ...mapActions('UserSet', [
      'loadGetToken'
    ]),
    pageClass () {
      let className = ''
      if (this.$route.path.includes('policy')) {
        className = 'policy'
      } else if (this.$route.path.includes('mytranggle')) {
        className = 'mypage'
      } else if (this.$route.path.includes('member')) {
        className = 'member'
      } else if (this.$route.path.includes('login')) {
        className = 'login'
      } else if (this.$route.path.includes('course')) {
        className = 'course'
      }
      return className
    }
  }
}
</script>

<style>
  @import './assets/common/css/tranggle.css';
  @import './assets/common/css/sports.css';
  @import './assets/common/css/publish.css';
</style>

export * from "-!../node_modules/mini-css-extract-plugin/dist/loader.js??ref--7-oneOf-1-0!../node_modules/css-loader/dist/cjs.js??ref--7-oneOf-1-1!../node_modules/vue-loader-v16/dist/stylePostLoader.js!../node_modules/postcss-loader/src/index.js??ref--7-oneOf-1-2!../node_modules/cache-loader/dist/cjs.js??ref--1-0!../node_modules/vue-loader-v16/dist/index.js??ref--1-1!./App.vue?vue&type=style&index=0&id=78b93970&lang=css"

~~~

## App.vue?8ecf

~~~vue
import { render } from "./App.vue?vue&type=template&id=78b93970"
import script from "./App.vue?vue&type=script&lang=js"
export * from "./App.vue?vue&type=script&lang=js"

import "./App.vue?vue&type=style&index=0&id=78b93970&lang=css"

import exportComponent from "/Users/kakaovx/Desktop/project/www-tranggle-frontend/node_modules/vue-loader-v16/dist/exportHelper.js"
const __exports__ = /*#__PURE__*/exportComponent(script, [['render',render]])

export default __exports__
~~~

## App.vue?ede6

~~~vue
export * from "-!../node_modules/mini-css-extract-plugin/dist/loader.js??ref--7-oneOf-1-0!../node_modules/css-loader/dist/cjs.js??ref--7-oneOf-1-1!../node_modules/vue-loader-v16/dist/stylePostLoader.js!../node_modules/postcss-loader/src/index.js??ref--7-oneOf-1-2!../node_modules/cache-loader/dist/cjs.js??ref--1-0!../node_modules/vue-loader-v16/dist/index.js??ref--1-1!./App.vue?vue&type=style&index=0&id=78b93970&lang=css"
~~~



## main.js

~~~js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from '@/store/index.js'
import common from '@/assets/common/js/common.js'
import commonAdmin from '@/assets/common/js/commonAdmin.js'
import axios from './util/axios.js'
import Vuecookies from 'vue-cookies'
// osm
import OpenLayersMap from 'vue3-openlayers'
import 'vue3-openlayers/dist/vue3-openlayers.css'

const app = createApp(App)
app.config.globalProperties.axios = axios
app.use(store)
app.use(router)
app.use(common)
app.use(commonAdmin)
app.use(Vuecookies)
app.use(OpenLayersMap)
app.mount('#app')

~~~



# View-course

~~~vue
<template>
  <div class="">
    <div class="header_wrap">
      <TopMenu currentMenu="course"/>
    </div>
  </div>
  <div class="container">
    <div class="course">
      <div class="course_nav">

        <ul>
            <router-link to="/course/" custom v-slot="{ href, isActive }">
              <li :class="[(checkUrl('') && isActive) && 'on']">
                <a @click="goUrl(href)"><span class="nav01"></span><span class="text">코스 검색</span></a>
              </li>
            </router-link>
            <!-- <router-link to="/course/book"
            custom v-slot="{ href, isActive}">
              <li :class="[isActive && 'on']"><a @click="goUrl(href)"><span class="nav02"></span><span class="text">코스북</span></a></li>
            </router-link> -->
            <!-- <router-link to="/course/theme"
            custom v-slot="{ href, isActive }">
              <li :class="[(checkUrl('theme') || isActive) && 'on']">
                <a @click="goUrl(href)"><span class="nav03"></span><span class="text">테마별<br>코스</span></a>
              </li>
            </router-link> -->
            <router-link to="/course/my" custom v-slot="{ href, isActive }">
              <li :class="[(checkUrl('my') || isActive) && 'on']">
                <a @click="goUrl(href)"><span class="nav04"></span><span class="text">나의 코스</span></a>
              </li>
            </router-link>
            <!-- <router-link to="/course/analyze"
            custom v-slot="{ href, isExactActive }">
              <li :class="[isExactActive && 'on']"><a @click="goUrl(href)"><span class="nav05"></span><span class="text">분석 제안</span></a></li>
            </router-link> -->
            <!-- <router-link to="/course/history"
            custom v-slot="{ href,
isExactActive }">
              <li :class="[isExactActive && 'on']"><a @click="goUrl(href)"><span class="nav06"></span><span class="text">코스 비교<br>히스토리</span></a></li>
            </router-link> -->
            <li>
              <a href="#" @click.prevent="gpxPopup"><span class="nav07"></span><span class="text">GPX<br>업로드</span></a>
              <!-- <router-link to="/course/gpx" @click.prevent="this.$store.commit('Course/controlUploadGPXFilePopup')"><span class="nav07"></span><span class="text">GPX<br>업로드</span></router-link> -->
            </li>
        </ul>
        <div v-if="$route.href.indexOf('/course/book') >= 0" class="course_termes">
          <a href="#" @click.prevent="this.$store.commit('Course/controlCourseBookAgreePopup')">코스북<br>이용약관</a>
          <a href="#" @click.prevent="this.$store.commit('Course/controlCourseBookAgreePopup')">코스북<br>이용방법</a>
        </div>
      </div><!--/course_nav-->
      <router-view></router-view>
    </div>
  </div><!--/container-->
  <CoursePopup />
</template>

<script>

import TopMenu from '../components/common/TopMenu.vue'
import CoursePopup from '../components/course/popup/CoursePopup.vue'

export default {
  data () {
    return {
    }
  },
  computed: {
  },
  methods: {
    goUrl (href) {
      this.$store.state.Course.domestic = true
      this.$store.state.Common.courseMenuType = ''
      // 메뉴 재클릭시 refresh
      if (this.$route.path === href) {
        this.$router.go()
      } else {
        this.$router.push(href)
      }
    },
    checkUrl (menuType) {
      let checkUrl = true
      if (this.$route.path.indexOf('/course/' + this.$route.params.id) > -1) {
        if (this.$store.state.Common.courseMenuType !== menuType) {
          checkUrl = false
        }
      } else {
        if (this.$route.path === '/course/my/gpx' && menuType === 'my') {
          checkUrl = true
        } else if (this.$route.path.indexOf('/course') > -1 && menuType !== '') {
          checkUrl = false
        }
      }
      return checkUrl
    },
    gpxPopup () {
      this.$store.commit('Course/controlUploadGPXFilePopup')
    }
  },
  watch: {
    $route (to, from) {
      if (to.path !== from.path) {
        this.$store.commit('Course/clearSearchOption')
        // this.$store.state.Course.isOpenCompareTrackPopup = false
      }
    }
  },
  mounted () {
    if (this.$store.state.UserSet.isLogin !== 'Y') {
      this.$router.push('/login')
    }
    // console.log(this.$store.state.Common.compareTrack1)
    // console.log(this.$store.state.Common.compareTrack2)
    // console.log(this.$store.state.Common.compareTrack1.no)
    // if (this.$store.state.Common.compareTrack1.no !== null || this.$store.state.Common.compareTrack2.no !== null) {
    //   console.log('in')
    //   this.$store.state.Common.isOpenCompareTrackPopup = true
    //   this.$store.state.Course.isOpenCompareTrackPopup = true
    //   console.log(this.$store.state.Common.isOpenCompareTrackPopup)
    // }
    // this.$store.state.Course.searchOrder = 'recommend'
  },
  components: {
    TopMenu: TopMenu,
    CoursePopup: CoursePopup
  }

}
</script>

<style>

</style>

~~~

~~~vue
import { render } from "./Course.vue?vue&type=template&id=2980cc44"
import script from "./Course.vue?vue&type=script&lang=js"
export * from "./Course.vue?vue&type=script&lang=js"

import exportComponent from "/Users/kakaovx/Desktop/project/www-tranggle-frontend/node_modules/vue-loader-v16/dist/exportHelper.js"
const __exports__ = /*#__PURE__*/exportComponent(script, [['render',render]])

export default __exports__
~~~





https://ssl.pstatic.net/static/maps/mantle/1x/zoom-in-small-normal.png

https://ssl.pstatic.net/static/maps/mantle/1x/zoom-out-small-normal.png\



# Component - Course

### Common - CoursePagination.vue

~~~vue
<template>
  <div class="list_page" v-if="this.totalPageCount > 0">
    <a href="#" class="i_left" @click.prevent="goPrePageBlock()"></a>
    <a href="#" v-for="i in this.pageList" :key="i" :class="{on: i === parseInt(this.currentPage)}" @click.prevent="$emit('select-list', i)">{{i}}</a>
    <a href="#" class="i_right" @click.prevent="goNextPageBlock()"></a>
  </div>
</template>

<script>
export default {
  name: 'CoursePagination',
  data () {
    return {
      pageListCount: 5, // 화면에 보일 페이지 수
      totalPageBlock: 0, // 전체 페이지 블럭 수
      currentPageBlock: 0, // 현재 페이지 블럭
      startPageNumber: 0, // 페이지 블럭 시작 번호
      endPageNumber: 0, // 페이지 블럭 끝 번호
      pageList: []
    }
  },
  watch: {
    currentPage () {
      this.createPagination()
    },
    totalPageCount () {
      this.createPagination()
    }
  },
  mounted () {
    this.createPagination()
  },
  methods: {
    goPrePageBlock () {
      if (this.currentPageBlock === 1) {
        this.$emit('select-list', 1)
      } else {
        this.$emit('select-list', ((this.currentPageBlock - 2) * this.pageListCount + 1))
      }
    },
    goNextPageBlock () {
      if (this.currentPageBlock === this.totalPageBlock) {
        this.$emit('select-list', this.totalPageCount)
      } else {
        this.$emit('select-list', (this.currentPageBlock * this.pageListCount + 1))
      }
    },
    createPagination () {
      this.pageList = []
      var pageCount = this.totalPageCount
      if (pageCount === 0) {
        pageCount = 50
      }
      this.totalPageBlock = Math.ceil(pageCount / this.pageListCount)
      this.currentPageBlock = Math.ceil(this.currentPage / this.pageListCount)
      this.startPageNumber = (Math.ceil(this.currentPage / this.pageListCount) - 1) * this.pageListCount + 1
      this.endPageNumber = ((this.startPageNumber + this.pageListCount - 1) > pageCount) ? pageCount : (this.startPageNumber + this.pageListCount - 1)

      for (let i = this.startPageNumber; i <= this.endPageNumber; i++) {
        this.pageList.push(i)
      }
    }
  },
  props: {
    totalPageCount: Number, // 전체 페이지 수
    currentPage: Number // 현재 페이지
  }
}
</script>

<style>

</style>

~~~

8d56

~~~vue
import { render } from "./CoursePagination.vue?vue&type=template&id=57726f15"
import script from "./CoursePagination.vue?vue&type=script&lang=js"
export * from "./CoursePagination.vue?vue&type=script&lang=js"

import exportComponent from "/Users/kakaovx/Desktop/project/www-tranggle-frontend/node_modules/vue-loader-v16/dist/exportHelper.js"
const __exports__ = /*#__PURE__*/exportComponent(script, [['render',render]])

export default __exports__
~~~



### Course-Detail

~~~vue
<template>
  <ModifyMyRecordPopup v-if="this.$store.state.Course.isOpenModifyMyRecordPopup"
    :courseInfo="this.courseInfo" @complete="this.getCourseInfo"/>
  <div class="course_left">
    <template v-if="courseInfo.track != null">
      <div class="section">
        <div class="top_title">
          <template v-if="this.$store.state.Common.courseMenuType === 'my'">
            나의 코스 상세
          </template>
          <template v-else>
            코스 상세
          </template>
          <span class="btn_area_l"><a @click.prevent="goList()" href="#" class="btn_back"></a></span>
          <!-- <span class="btn_area_r"><a href="#" class="btn_s btn_org"
            @click="courseCompare(this.compareTrackData)">코스 비교</a></span> -->
        </div>
      </div>
      <div class="section">
        <div class="course_title">
          <span class="subject">
            <span class="icon_exc" :class="`icon_exc ` + this.$categoryImage(courseInfo.track.log_category)"></span>
            <span class="text">{{courseInfo.track.log_track_name}}</span>
            <template v-if="this.$store.state.Common.courseMenuType === 'my'
            && this.$store.state.Member.memberId === courseInfo.member.member_id">
              <!-- <span class="btn_edit" @click="this.$store.commit('Course/controlModifyMyRecordPopup')"></span> -->
            </template>
          </span>
          <template v-if="this.$store.state.Common.courseMenuType === 'my'
            && this.$store.state.Member.memberId === courseInfo.member.member_id">
            <div class="hashtag elp2">
              <a href="#" v-for="(tag, i) in getTagList" :key="i">#{{tag.tag_name}}</a>
            </div>
            <div class="hashtag_more" v-if="getTagList.length > 10"><a href="#" class="btn_more" @click="this.isOpenHashTagPopup = true">더보기</a>
              <div class="hashtag_more_layer" v-show="this.isOpenHashTagPopup">
                <div class="popup_box popup_box_s">
                  <div class="popup_top line_bottom"><h2>#해시태그</h2>
                  <a href="#" class="btn_close" @click="this.isOpenHashTagPopup = false"></a>
                  </div>
                  <div class="popup_body">
                    <div class="hashtag">
                      <a href="#" v-for="(tag, i) in getTagList" :key="i">#{{tag.tag_name}}</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </template>
          <span class="date">{{courseInfo.track.log_last_update}}</span>
        </div>
      </div>
      <div class="course_user" v-if="courseInfo.member.member_id">
        <div class="section">
          <div class="user_g">
            <span class="user_profile"><img :src="courseInfo.member.member_photo_small" /></span>
            <span class="user_info">
              <span class="user_id">{{courseInfo.member.member_nickname || courseInfo.member.member_id}}</span>
              <span class="user_level">LV{{courseInfo.member.level}}</span>
              <!-- <span class="user_link">
                <router-link :to="`/mytranggle/friendInfo/` + courseInfo.member.member_id" style="color:#333">작성자 홈</router-link>
                <a :href="`/story/${courseInfo.track.story_post_no}`" v-if="courseInfo.track.story_post_no != null">스토리 본문</a>
              </span> -->
            </span>
          </div>
        </div>
      </div>
      <div class="user_action2">
        <span class="t_block">
          <span :class="[{'i_like':true}, {'on': !this.courseInfo.track.recommendable}]"
            @click.prevent="recommendCourse"></span>
          <span
            :class="[{'i_drop' : courseInfo.track.log_recommend_count > 0}, {'on': this.isOpenRecommendUserList}]"
            @click="changeVisibleRecommendUserList">
            <span class="text">{{this.$addComma(courseInfo.track.log_recommend_count)}}</span>
            <div class="i_like_layer" v-if="courseInfo.track.log_recommend_count > 0">
              {{this.recommendUserList}}
            </div>
          </span>
        </span>
        <span class="t_block">
          <span class="i_view"></span><span class="text">{{this.$addComma(courseInfo.track.log_hit)}}</span>
        </span>
        <!-- <span class="t_block" @click="this.sharePage">
          <span class="i_share_m"></span><span class="text">{{this.$addComma(courseInfo.track.log_share_count)}}</span>
        </span> -->
        <span class="t_block" @click.prevent="downloadTrack">
        <!-- 트랭 차감 기능 붙을때까지 다운로드 막기 -->
        <!-- <span class="t_block"> -->
          <span class="i_down"></span><span class="text">{{this.$addComma(courseInfo.track.log_download_count)}}</span>
        </span>
      </div>
      <div class="tab_menu">
        <ul>
          <router-link :to="recordUrl" custom v-slot="{ href, navigate }" class="block_click">
            <li><a :href="href" @click="navigate" class="block_click">운동기록</a></li>
          </router-link>
          <!-- <router-link :to="infoUrl" custom v-slot="{ href, navigate, isExactActive }">
            <li :class="[isExactActive && 'on']"><a :href="href" @click="navigate">코스 설명</a></li>
          </router-link>
          <router-link :to="badgeUrl" custom v-slot="{ href, navigate, isExactActive }">
            <li :class="[isExactActive && 'on']"><a :href="href" @click="navigate">획득배지({{courseInfo.badge_list.length}})</a></li>
          </router-link>
          <router-link :to="commentUrl" custom v-slot="{ href, navigate, isExactActive }">
            <li :class="[isExactActive && 'on']"><a :href="href" @click="navigate">댓글({{courseInfo.track.comment_total_count}})</a></li>
          </router-link> -->
        </ul>
      </div>
      <router-view :courseInfo="this.courseInfo" :trackKey="this.trackNo"></router-view>
    </template>
  </div><!--/course_left-->
  <div class="content">
    <CourseMap :trackNo="this.trackNo" ref="map" v-if="Object.keys(this.courseInfo).length > 0"/>
  </div><!--/content-->
</template>

<script>
// import axios from 'axios'
import CourseMap from '../map/CourseMap.vue'
import ModifyMyRecordPopup from '../popup/ModifyMyRecordPopup.vue'
import { mapState } from 'vuex'

export default {
  name: 'courseDetail',
  data () {
    const trackNo = this.$route.params.id

    return {
      recordUrl: '/course/' + trackNo,
      infoUrl: '/course/' + trackNo + '/info',
      badgeUrl: '/course/' + trackNo + '/badge',
      commentUrl: '/course/' + trackNo + '/comment',
      trackNo: String(trackNo),
      recommendUserList: '',
      isOpenRecommendUserList: false,
      isOpenHashTagPopup: false,
      logNo: '',
      trackYear: '',
      courseInfo: {},
      compareTrackData: {}
    }
  },
  watch: {
    // $route (to, from) {
    //   if (String(to.path).indexOf('badge') > -1) {
    //     this.$refs.map.showCourseBadgeList()
    //   } else {
    //     this.$refs.map.hideCourseBadgeList()
    //   }
    // }
  },
  props: {
    id: Number
  },
  components: {
    CourseMap: CourseMap,
    ModifyMyRecordPopup: ModifyMyRecordPopup
  },
  async mounted () {
    if (this.trackNo.length < 5) {
      alert('잘못된 접근입니다.')
      this.$router.go(-1)
    }

    this.trackYear = this.trackNo.substring(0, 4)
    this.logNo = this.trackNo.substring(4, this.trackNo.length)

    this.getCourseInfo()
  },
  computed: {
    ...mapState('UserSet', ['memberId', 'memberNick']),
    getTagList () {
      return this.courseInfo.tags
    }
  },
  methods: {
    courseCompare (data) {
      if ((this.$store.state.Common.compareTrack1.year === data.year && this.$store.state.Common.compareTrack1.no === data.no) ||
            (this.$store.state.Common.compareTrack2.year === data.year && this.$store.state.Common.compareTrack2.no === data.no)) {
        this.$showMessagePopup('', '이미 코스 비교에 등록된 코스입니다.')
      } else if (this.$store.state.Common.compareTrack1.name !== '' && this.$store.state.Common.compareTrack2.name !== '') {
        this.$showConfirmPopup('', '이미 2개의 코스가 비교 대상으로<br>등록되어 있습니다.<br>새롭게 코스 비교하시겠습니까?', () => {
          this.$store.state.Common.compareTrack1.name = ''
          this.$store.state.Common.compareTrack1.year = ''
          this.$store.state.Common.compareTrack1.no = ''
          this.$store.state.Common.compareTrack2.name = ''
          this.$store.state.Common.compareTrack2.year = ''
          this.$store.state.Common.compareTrack2.no = ''
          this.$store.commit('Common/setCompareTrack', data)
        })
      } else {
        this.$store.commit('Common/setCompareTrack', data)
      }
    },
    goList () {
      let path = ''
      if (this.$store.state.Common.courseMenuType === '') {
        path = '/course/'
      } else if (this.$store.state.Common.courseMenuType === 'theme') {
        path = '/course/theme/' + this.$store.state.Common.themaCategoryNo
      } else if (this.$store.state.Common.courseMenuType === 'my') {
        path = '/course/my/'
      } else if (this.$store.state.Common.courseMenuType === 'analyze') {
        path = '/course/analyze/'
      }
      this.$refs.map.clearCourseMarker()
      this.$router.push({ path: path, query: this.$route.query })
    },
    async getCourseInfo () {
      if (this.trackYear === null || this.logNo === 0) return
      this.axios.get('/Track/track_detail.json', {
        params: {
          track_key: this.trackNo
        }
      })
        .then(data => {
          const responseCode = data.data.response.code
          if (responseCode !== '00') {
            this.$showMessagePopup('', data.data.response.message, '/course')
          } else {
            this.courseInfo = data.data.response.content
            this.$store.state.Course.courseInfo = this.courseInfo
            this.$store.commit('Course/setBadgeList', this.courseInfo.badge_list)
            this.compareTrackData = {
              name: this.courseInfo.track.log_track_name,
              year: this.trackYear,
              no: this.logNo
            }

            // if (this.courseInfo.track.log_recommend_count > 0) {
            this.axios.get('/Track/recommended_user_list.json', {
              params: {
                track_key: this.trackNo
              }
            })
              .then(data2 => {
                const recommendUserList = data2.data.response.content
                for (let i = 0; i < recommendUserList.length; i++) {
                  if (i > 0) {
                    this.recommendUserList += ', '
                  }
                  this.recommendUserList += recommendUserList[i].recommend_member_id
                }
              })
            // }
          }
        })
    },
    copyUrl () {
      const t = document.createElement('textarea')
      document.body.appendChild(t)
      t.value = location.href
      t.select()
      document.execCommand('copy')
      document.body.removeChild(t)
      this.$showMessagePopup('URL 복사', '이 코스의 주소가 복사되었습니다. 메신저 또는 텍스트 입력창에서 Ctrl+V를 눌러보세요.')
    },
    changeVisibleRecommendUserList () {
      this.isOpenRecommendUserList = !this.isOpenRecommendUserList
    },
    downloadTrack () {
      this.$showConfirmPopup('파일 다운로드', 'GPX 파일을 다운로드하겠습니까?', () => {
        location.href = `/v2/track/download?track_key=${this.trackNo}&down_type=mileage`
      })
      // const formData = new FormData()
      // formData.append('token', this.$store.state.Member.token)
      // formData.append('track_key', this.trackNo)
      // formData.append('way', 'trang')

      // this.axios.post('/Track/download.json', formData)
      //   .then(data => {
      //     const responseCode = data.data.response.code

      //     if (responseCode === '00') {
      //       this.$showMessagePopup('', data.data.response.message)
      //       this.courseInfo.track.log_download_count = Number(this.courseInfo.track.log_download_count) + 1
      //     } else {
      //       this.$showMessagePopup('', data.data.response.message)
      //     }
      //   })
    },
    recommendCourse () {
      if (this.courseInfo.track.recommendable) {
        const formData = new FormData()
        formData.append('track_key', this.trackNo)
        this.axios.post('/course/recommend.json', formData)
          .then(data => {
            const responseCode = data.data.response.code
            if (responseCode === '00') {
              this.courseInfo.track.recommendable = false
              this.courseInfo.track.log_recommend_count++
              this.recommendUserList += this.recommendUserList.length === 0 ? this.memberNick || this.memberId : `,${this.memberNick || this.memberId}`
            } else {
              this.$showMessagePopup('코스 추천', data.data.response.message)
            }
          })
      }
    },
    sharePage () {
      this.$store.state.Popup.sendId = this.courseInfo.member.member_id
      this.$store.state.Popup.sendNickName = this.courseInfo.member.member_nickname
      this.$store.state.Popup.sharePageChk = 'course'
      this.$store.state.Popup.sharePostNo = this.logNo
      this.$store.state.Popup.shereYear = this.trackYear
      this.$store.commit('Popup/controlSharePopup')
    }
  }
}
</script>

<style>
</style>
~~~

920b

~~~vue
import { render } from "./Detail.vue?vue&type=template&id=a8b3c2c2"
import script from "./Detail.vue?vue&type=script&lang=js"
export * from "./Detail.vue?vue&type=script&lang=js"

import exportComponent from "/Users/kakaovx/Desktop/project/www-tranggle-frontend/node_modules/vue-loader-v16/dist/exportHelper.js"
const __exports__ = /*#__PURE__*/exportComponent(script, [['render',render]])

export default __exports__
~~~



### Course - DetailBadge.vue

~~~vue
<template>
  <div class="left_content" :style="this.getLeftContentHeight">
    <div class="list_badge">
      <ul>
        <li v-for="(badge, i) in this.$store.state.Course.badgeList" :key="i" :class="{on: i === this.$store.state.Course.selectedBadgeIndex}" @click="this.selectedBadge(i)">
          <span class="td1"><span class="poi_badge"><img :src="this.$photoEmpty(badge.badge_image_url)" /></span></span>
          <span class="td2">
            <span class="poi_content">
              <span class="subject"><span class="text elp">{{badge.info_badge_name}}</span></span>
              <span class="sub_text">{{badge.info_badge_message}}</span>
              <span class="data">
                <span class="text"><span class="t1">획득 경험치</span>{{badge.info_reward}}</span>
                <span class="text"><span class="t1">배지 획득 방법</span>{{badge.how_to_get}}</span>
              </span>
            </span>
          </span>
        </li>
      </ul>
    </div><!--/course_badge-->
  </div>
</template>

<script>

export default {
  name: 'courseDetailBadge',
  data () {
    return {
      selectedBadgeIndex: -1
    }
  },
  props: {
    courseInfo: Object,
    trackYear: String
  },
  computed: {
    getLeftContentHeight () {
      if (this.$store.state.Common.courseMenuType === 'my' &&
        this.$store.state.Member.memberId === this.courseInfo.member.member_id) {
        return 'height: calc(100vh - 500px);'
      } else {
        return 'height: calc(100vh - 414px);'
      }
    }
  },
  methods: {
    selectedBadge (index) {
      this.$store.commit('Course/setSelectedBadgeIndex', index)
    }
  },
  mounted () {
    this.$store.state.Course.isVisibleCourseBadge = true
  }
}
</script>

<style>

</style>
~~~



### 

 
