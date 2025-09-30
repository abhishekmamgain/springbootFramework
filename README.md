# Spring Boot Test Automation Framework

A comprehensive test automation framework built with Spring Boot, TestNG, and Selenium WebDriver. This framework provides a robust foundation for UI testing with dependency injection, page object model implementation, and multi-browser support.

## Features

- **Spring Boot Integration**: Leverages Spring's dependency injection for test management
- **Page Object Model**: Clean separation of test logic and page interactions
- **Multi-Browser Support**: Chrome, Firefox, Edge, and Safari drivers
- **TestNG Framework**: Advanced test execution with parallel support
- **WebDriverManager**: Automatic driver management and updates
- **Configuration Profiles**: Environment-specific test configurations
- **TestContainers**: Docker-based browser testing (optional)

## Prerequisites

Before setting up the framework, ensure you have the following installed:

### Required Software

1. **Java Development Kit (JDK) 11 or higher**
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
   - Verify installation: `java -version`

2. **Apache Maven 3.6+**
   - Download from [Maven Official Site](https://maven.apache.org/download.cgi)
   - Add Maven to your system PATH
   - Verify installation: `mvn -version`

3. **Git** (for version control)
   - Download from [Git Official Site](https://git-scm.com/downloads)

### Optional Software

- **Docker Desktop** (for TestContainers support)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions

## Project Structure

```
src/
├── main/
│   ├── java/com/ea/SpringStart/
│   │   ├── SpringStartApplication.java    # Main Spring Boot application
│   │   ├── Car.java                       # Sample business logic
│   │   └── libraries/
│   │       └── WebDriverLibrary.java      # WebDriver configuration
│   └── resources/
│       ├── application.properties         # Default configuration
│       ├── application-dev.properties     # Development environment
│       └── application-qa.properties      # QA environment
└── test/
    └── java/com/ea/SpringStart/
        ├── PageObjectTest.java            # Main UI test class
        ├── SimpleTestNGTest.java          # Basic TestNG example
        ├── SpringStartApplicationTests.java # JUnit 5 context tests
        ├── SpringTestNGTests.java         # TestContainers tests
        └── pages/
            ├── BasePage.java              # Base page object
            ├── HomePage.java              # Home page object
            └── LoginPage.java             # Login page object
```

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd springbootFramework
```

### 2. Configure Environment Variables

Set up your Java and Maven environment:

**Windows:**
```cmd
set JAVA_HOME=C:\path\to\your\jdk
set PATH=%JAVA_HOME%\bin;%PATH%
set MAVEN_HOME=C:\path\to\your\maven
set PATH=%MAVEN_HOME%\bin;%PATH%
```

**Linux/Mac:**
```bash
export JAVA_HOME=/path/to/your/jdk
export PATH=$JAVA_HOME/bin:$PATH
export MAVEN_HOME=/path/to/your/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

### 3. Verify Installation

Run the following commands to ensure everything is properly configured:

```bash
java -version
mvn -version
```

### 4. Build the Project

```bash
mvn clean compile
```

## Configuration

### Browser Configuration

The framework supports multiple browsers through configuration properties:

**application.properties:**
```properties
browser=Chrome
app.url=http://eaapp.somee.com
```

**application-dev.properties:**
```properties
browser=Chrome
app.url=http://eaapp.somee.com
```

**application-qa.properties:**
```properties
browser=Chrome
app.url=http://qa-eaapp.somee.com
```

### Supported Browsers

- Chrome (default)
- Firefox
- Edge
- Safari

## Running Tests

### 1. Run All Tests

```bash
mvn test
```

### 2. Run Specific Test Class

```bash
mvn test -Dtest=PageObjectTest
```

### 3. Run Specific Test Method

```bash
mvn test -Dtest=PageObjectTest#testLoginFlow
```

### 4. Run Tests with Specific Profile

```bash
mvn test -Dspring.profiles.active=dev
```

### 5. Run Tests with Different Browser

```bash
mvn test -Dbrowser=Firefox
```

### 6. Debug Mode

To run tests in debug mode (for IDE debugging):

```bash
mvn -Dmaven.surefire.debug test
```

Then attach your debugger to `localhost:5005`.

## IDE Setup

### IntelliJ IDEA

1. Import as Maven project
2. Install TestNG plugin
3. Configure Run/Debug configurations for TestNG
4. Set breakpoints and use "Debug Test" option

### VS Code

1. Install Extension Pack for Java
2. Install Test Runner for Java
3. Use the provided `.vscode/launch.json` for debugging
4. Set breakpoints and use "Debug Test" code lens

### Eclipse

1. Import as Maven project
2. Install TestNG plugin
3. Right-click test class → Run As → TestNG Test

## Test Execution Examples

### Basic Navigation Test

```java
@Test
public void testPageNavigation() {
    homePage.Navigate(appUrl);
    Assert.assertNotNull(homePage, "HomePage should be injected");
    System.out.println("Successfully navigated to: " + appUrl);
}
```

### Login Flow Test

```java
@Test
public void testLoginFlow() {
    homePage.Navigate(appUrl);
    LoginPage loginPageResult = homePage.ClickLogin();
    loginPage.Login("admin", "password");
    HomePage homePageResult = loginPage.ClickLogin();
    Assert.assertNotNull(homePageResult, "Should navigate back to home page");
}
```

## Troubleshooting

### Common Issues

1. **WebDriver Issues**
   - Ensure browser is installed and up to date
   - Check internet connection for WebDriverManager downloads
   - Verify browser configuration in properties files

2. **Maven Build Issues**
   - Check Java and Maven versions
   - Clear Maven cache: `mvn dependency:purge-local-repository`
   - Rebuild project: `mvn clean install`

3. **Test Execution Issues**
   - Verify application URL is accessible
   - Check test data and credentials
   - Review test logs in `target/surefire-reports/`

### Debug Tips

- Use `@TestPropertySource` to override configuration for specific tests
- Enable debug logging by adding `logging.level.com.ea.SpringStart=DEBUG`
- Use browser developer tools to inspect page elements
- Check WebDriver logs for element interaction issues

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
