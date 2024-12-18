
 JobPortal  
A full-stack job management platform built to connect job seekers with employers, leveraging modern web technologies and robust backend services.



 Table of Contents  

1. [Overview](overview)  
2. [Architecture](architecture)  
3. [Tech Stack](tech-stack)  
4. [Features](features)  
5. [Setup and Installation](setup-and-installation)  
6. [API Endpoints](api-endpoints)  
7. [Database Schema](database-schema)  
8. [Contributing](contributing)  
9. [License](license)  
10. [Contact](contact)  



 Overview  

JobPortal is a full-stack web application enabling job seekers to discover opportunities and employers to post job openings efficiently. Built using Spring Boot for a scalable backend and a responsive frontend, the system integrates authentication, data persistence, and REST APIs for smooth interaction.



 Architecture  

The application follows a 3-tier architecture:  

- Frontend: Static pages rendered using HTML, CSS, Bootstrap, and JavaScript.  
- Backend: RESTful APIs powered by Spring Boot, providing data handling and business logic.  
- Database: MySQL for relational data storage with JPA and Hibernate ORM integration.  

The application also incorporates Maven for dependency management and Git for version control.  



 Tech Stack  

 Backend  
- Java 17  
- Spring Boot 3.x  
- Spring Data JPA (Hibernate ORM)  
- REST APIs  
- Maven (Build tool)  

 Frontend  
- HTML5, CSS3  
- Bootstrap 5  
- JavaScript (Vanilla JS)  

 Database  
- MySQL 8.x  

 Tools & Platforms  
- Git and GitHub (Version Control)  
- Postman (API Testing)  
- IntelliJ IDEA / VS Code (Development IDE)  
- MySQL Workbench  



 Features  

 Job Seekers  
- User authentication (Sign Up, Login).  
- Browse, search, and filter job listings using RESTful APIs.  
- Apply to jobs and upload resumes.  

 Employers  
- Create, update, and delete job postings.  
- View and filter applicant data.  
- Manage job status (Open/Closed).  

 General  
- Secure APIs using JWT Authentication (future enhancement).  
- Responsive UI for a seamless experience across devices.  
- Modular project structure for scalability and maintainability.  



 Setup and Installation  

 Prerequisites  
Ensure the following are installed:  
- Java 17  
- MySQL 8.x  
- Maven 3.x  



 1. Clone the Repository  
 
git clone https://github.com/Arrk01/JobPortal.git  
cd JobPortal  
```



 2. Backend Setup  

1. Configure Database:  
   - Create a MySQL database named `job_portal`.  
   - Update `application.properties` in the Spring Boot project:  
     ```properties  
     spring.datasource.url=jdbc:mysql://localhost:3306/job_portal  
     spring.datasource.username=root  
     spring.datasource.password=password  
     spring.jpa.hibernate.ddl-auto=update  
     spring.jpa.show-sql=true  
     ```

2. Build and Run the Backend  
    
   mvn clean install  
   mvn spring-boot:run  
   ```

   - Backend runs on http://localhost:8080.  



 3. Frontend Setup  

- Open `index.html` in a browser.  
- Alternatively, use a simple HTTP server like VS Code's Live Server extension:  
    
   npx http-server ./frontend -p 8081  
   ```

- Frontend runs on http://localhost:8081.



 API Endpoints  

| Method     | Endpoint                      | Description                          |
| `POST`     | `/api/auth/register`          | Register a new user.                 |
| `POST`     | `/api/auth/login`             | Authenticate and obtain a token.     |
| `GET`      | `/api/jobs`                   | Retrieve all job listings.           |
| `POST`     | `/api/jobs`                   | Create a new job posting (Employer). |
| `GET`      | `/api/jobs/{id}`              | Get details of a specific job.       |
| `PUT`      | `/api/jobs/{id}`              | Update a job posting.                |
| `DELETE`   | `/api/jobs/{id}`              | Delete a job posting.                |
| `POST`     | `/api/jobs/{id}/apply`        | Apply to a job (Job Seeker).         |



 Database Schema  

 Users Table  
| Column       | Type          | Description          |   
| id           | INT (PK)      | Auto-increment ID.   |  
| username     | VARCHAR(255)  | Unique username.     |  
| password     | VARCHAR(255)  | Encrypted password.  |  
| role         | ENUM          | USER/EMPLOYER.       |  

 Jobs Table  
| Column       | Type          | Description          |   
| id           | INT (PK)      | Auto-increment ID.   |  
| title        | VARCHAR(255)  | Job title.           |  
| description  | TEXT          | Job description.     |  
| company      | VARCHAR(255)  | Employer company.    |  
| location     | VARCHAR(255)  | Job location.        |  

 Applications Table  
| Column       | Type          | Description          |  
| id           | INT (PK)      | Auto-increment ID.   |  
| job_id       | INT (FK)      | Reference to Job ID. |  
| user_id      | INT (FK)      | Reference to User ID.|  
| resume_link  | VARCHAR(255)  | Uploaded resume URL. |  



 Contributing  

Contributions are welcome! Follow these steps:  

1. Fork the repository.  
2. Create a new branch: `git checkout -b feature/YourFeatureName`.  
3. Commit your changes: `git commit -m "Add feature: XYZ"`.  
4. Push to your branch: `git push origin feature/YourFeatureName`.  
5. Open a Pull Request.  



 License  

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.  



 Contact  

- Developer: Abhishek Kumar  
- GitHub: [Arrk01](https://github.com/Arrk01)  
- Email: itzabhi1114@gmail.com

For questions, feedback, or feature requests, feel free to reach out! 🚀  
