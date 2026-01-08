# 레시피 프로바이더 리더

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-blue.svg?style=flat-square)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.6.3-blue.svg?style=flat-square)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)

`ContentProvider`의 데이터를 사용하는 방법을 보여주는 샘플 안드로이드 애플리케이션입니다. 이 프로젝트는 깔끔하고 확장 가능하며 유지보수하기 좋은 아키텍처를 강조하는 최신 안드로이드 개발 방식을 보여줍니다.

## 📸 스크린샷

*(사용자가 앱을 시각적으로 이해할 수 있도록 여기에 애플리케이션 스크린샷을 추가하세요.)*

## ✨ 기능

-   **Content Provider 통합:** 외부 `ContentProvider`에서 원활하게 데이터를 가져옵니다.
-   **최신 UI:** 선언적이고 반응적인 UI를 위해 전체를 Jetpack Compose로 빌드했습니다.
-   **상태 관리:** `ViewModel`을 활용하여 UI 상태를 관리하고 노출하며, 구성 변경에도 상태를 유지합니다.
-   **비동기 작업:** 효율적인 백그라운드 데이터 로딩을 위해 Kotlin 코루틴과 `Flow`를 활용합니다.
-   **클린 아키텍처:** 관심사를 분리하고 테스트 용이성을 향상시키기 위해 MVVM 원칙을 따릅니다.

## 🛠️ 기술 스택 및 라이브러리

-   **[Kotlin](https://kotlinlang.org/)**: 안드로이드 개발의 공식 언어입니다.
-   **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: 네이티브 UI를 빌드하기 위한 안드로이드의 최신 툴킷입니다.
-   **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: UI 관련 데이터를 생명주기를 고려하여 관리합니다.
-   **[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)**: 백그라운드 작업 및 비동기 연산을 관리합니다.
-   **[ContentResolver](https://developer.android.com/guide/topics/providers/content-provider-basics)**: `ContentProvider`와 상호 작용하기 위한 핵심 구성 요소입니다.

## 🏗️ 프로젝트 구조

이 프로젝트는 클린 아키텍처의 원칙에 따라 구성되었습니다.

```
.
├── app
│   ├── src/main/java
│   │   └── com/ezlevup/recipeproviderreader
│   │       ├── MainActivity.kt         # 애플리케이션의 메인 진입점
│   │       ├── presentation
│   │       │   ├── MyApp.kt            # 애플리케이션 클래스
│   │       │   ├── home
│   │       │   │   ├── HomeScreen.kt   # 메인 화면을 위한 컴포저블 UI
│   │       │   │   ├── HomeState.kt    # 홈 화면의 상태를 정의
│   │       │   │   └── HomeViewModel.kt# 홈 화면을 위한 ViewModel
│   │       │   └── components
│   │       │       └── Greeting.kt     # 샘플 컴포저블
│   │       └── ...
│   └── build.gradle.kts
└── ...
```

## 🚀 시작하기

### 사전 요구 사항

-   Android Studio Iguana | 2023.2.1 또는 최신 버전.
-   `com.survivalcoding.gangnam2kiandroidstudy.provider` 권한을 가진 `ContentProvider`를 노출하는 애플리케이션.

### 설치 및 실행

1.  저장소를 복제합니다:
    ```bash
    git clone https://github.com/your-username/recipe-provider-reader.git
    ```
2.  Android Studio에서 프로젝트를 엽니다.
3.  필요한 `ContentProvider` 애플리케이션이 대상 기기 또는 에뮬레이터에 설치되어 있는지 확인합니다.
4.  `app` 모듈을 빌드하고 실행합니다.

## 🤔 작동 방식

애플리케이션의 로직은 `HomeViewModel`을 중심으로 합니다.

1.  `HomeScreen`이 구성될 때, `HomeViewModel`의 상태를 관찰합니다.
2.  `HomeViewModel`이 초기화되고, `init` 블록에서 데이터를 가져오기 위해 코루틴을 시작합니다.
3.  `ContentResolver`를 사용하여 `content://com.survivalcoding.gangnam2kiandroidstudy.provider/bookmarks` URI에서 `ContentProvider`를 쿼리합니다.
4.  쿼리는 `Cursor`를 반환합니다. ViewModel은 커서를 반복하면서 북마크(레시피 ID) 데이터를 추출하고 `HomeState`를 업데이트합니다.
5.  `HomeScreen`은 상태가 변경되면 자동으로 리컴포지션되어 `LazyColumn`에 레시피 ID 목록을 표시합니다.

## 📜 라이선스

이 프로젝트는 Apache 2.0 라이선스가 적용됩니다.
