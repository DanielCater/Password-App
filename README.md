# Password Generator & Analyzer
A JavaFX desktop application that provides two main tools:
- Password Generator — create secure, customizable passwords
- Password Analyzer — evaluate password strength and structure
Built using Java 21, JavaFX 21, and Maven, with a clean tab‑based UI.

## Features
### Password Generator
- Generate secure passwords
- Copy‑friendly output field
- Press Enter to generate
- Clean, centered layout
### Password Analyzer
- Analyze password length and structure
- Instant feedback
- Press Enter to analyze
### Multi‑Tab Interface
- Generator and Analyzer each have their own tab
- Smooth, organized layout

## Technologies Used
| Component | Version |
|----------|---------|
| Java     | 21      |
| JavaFX   | 21.0.2  |
| Maven    | 3.x     |
| NetBeans | 19+     |
| GitHub   | Remote repository |



## System Requirements
To run this project, you must have:
- JDK 21 installed
- JAVA_HOME pointing to JDK 21
- PATH using JDK 21 before any other JDK
- Maven installed (or use NetBeans’ built‑in Maven)
JavaFX does not run on Java 24, so JDK 21 is required.

## How to Build & Run
1. Clone the Repository
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>


2. Run with Maven
mvn clean javafx:run


3. Or Run from NetBeans
- Open the project
- Ensure the project uses JDK 21
- Right‑click → Run

## Common Setup Issues & Fixes
1. JavaFX fails with “Process exited with error: 1”
This happens when Maven uses the wrong JDK.
Fix:
- Set JAVA_HOME to JDK 21
- Ensure %JAVA_HOME%\bin is first in PATH
- Restart terminal/NetBeans
- Run mvn -v to confirm Java 21 is active
2. GitHub rejects username/password
GitHub no longer accepts real passwords for Git.
Fix:
- Create a Personal Access Token
- Use:
- Username: your GitHub username
- Password: your token

## Roadmap / Future Features
- Strength meter visualization
- Advanced generator options (symbols, length slider, toggles)
- Export/import settings


