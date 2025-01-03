# Homeopathy For All

This is a Spring Boot application for managing users (patients and doctors) in a homeopathy system. The application provides functionalities for user registration, login, and password management.

## Technologies Used

- Java
- Spring Boot
- Maven
- Lombok
- Spring Security

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- An IDE like IntelliJ IDEA

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ferricstark/homeopathy-for-all.git
    cd homeopathy-for-all
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

### User Registration

- **Register Patient**
    ```http
    POST /api/users/register/patient
    ```
    **Request Body:**
    ```json
    {
      "username": "patient1",
      "password": "password123",
      "email": "patient1@example.com"
    }
    ```

- **Register Doctor**
    ```http
    POST /api/users/register/doctor
    ```
    **Request Body:**
    ```json
    {
      "username": "doctor1",
      "password": "password123",
      "firstName": "John",
      "lastName": "Doe",
      "email": "doctor1@example.com",
      "specialization": "Cardiology",
      "yearsOfExperience": "10",
      "contactInfo": "123-456-7890"
    }
    ```

### User Login

- **Patient Login**
    ```http
    POST /api/users/login/patient
    ```
    **Request Parameters:**
    - `username`: Patient's username
    - `password`: Patient's password

- **Doctor Login**
    ```http
    POST /api/users/login/doctor
    ```
    **Request Parameters:**
    - `username`: Doctor's username
    - `password`: Doctor's password

### Password Management

- **Forgot Password**
    ```http
    POST /api/users/forgot-password
    ```
    **Request Parameters:**
    - `username`: User's username

- **Reset Password**
    ```http
    POST /api/users/reset-password
    ```
    **Request Parameters:**
    - `token`: Password reset token
    - `newPassword`: New password

## License

This project is licensed under the MIT License.
