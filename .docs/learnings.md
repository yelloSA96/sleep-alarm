# learnings
Typical folder Structure for android application
```md
app/
├── src/
│   ├── main/
│   │   ├── java/com/yourcompany/yourapp/
│   │   │   ├── models/           # Data models/POJOs
│   │   │   │   ├── User.java
│   │   │   │   └── ApiResponse.java
│   │   │   │
│   │   │   ├── network/          # API-related classes
│   │   │   │   ├── ApiClient.java      # Retrofit instance
│   │   │   │   ├── ApiService.java     # API endpoints
│   │   │   │   └── ApiCallback.java    # Custom callbacks
│   │   │   │
│   │   │   ├── repository/       # Data layer (optional but recommended)
│   │   │   │   └── UserRepository.java
│   │   │   │
│   │   │   ├── ui/               # UI components
│   │   │   │   ├── activities/
│   │   │   │   │   └── MainActivity.java
│   │   │   │   ├── fragments/
│   │   │   │   └── adapters/
│   │   │   │
│   │   │   ├── viewmodels/       # ViewModels (if using MVVM)
│   │   │   │   └── UserViewModel.java
│   │   │   │
│   │   │   └── utils/            # Utility classes
│   │   │       ├── Constants.java
│   │   │       └── NetworkUtils.java
│   │   │
│   │   ├── res/                  # Resources
│   │   │   ├── layout/
│   │   │   ├── values/
│   │   │   └── drawable/
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── test/                     # Unit tests
│
└── build.gradle                  # Dependencies
```