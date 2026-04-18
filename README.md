# PluginTemplate

Minecraft **26.1.2** Paper + Kotlin 플러그인 템플릿.

## 구조

모든 메타데이터는 **`gradle.properties` 한 곳**에서 관리됩니다.
값을 변경하면 `build.gradle.kts`와 `plugin.yml`에 자동으로 반영됩니다.

```properties
# gradle.properties
group=com.aloedawn          # 도메인 (패키지 경로 기준)
version=1.0.0               # 플러그인 버전
pluginName=PluginTemplate   # 플러그인 이름 (jar 이름·루트 프로젝트명)
pluginDescription=...       # 설명
pluginAuthor=aloedawn       # 제작자
pluginMainClass=MainClass   # 메인 클래스 이름

mcVersion=26.1.2            # Paper API 버전
mcApiVersion=26.1           # plugin.yml api-version

ktVersion=2.3.20            # Kotlin
javaVersion=25              # JDK toolchain
```

메인 클래스 FQN은 `<group>.<pluginName(lowercase)>.<pluginMainClass>` 규칙으로
자동 생성됩니다 — 예: `com.aloedawn.plugintemplate.MainClass`.

## 새 플러그인으로 분기할 때

1. `gradle.properties`에서 `group`, `pluginName`, `pluginDescription` 수정
2. `src/main/kotlin/<group>/<pluginName(lowercase)>/` 경로로 소스 폴더 이동
3. `MainClass.kt`의 `package` 선언을 새 경로로 변경

## 빌드

```bash
./gradlew shadowJar
# → build/libs/<pluginName>-<version>.jar
```
