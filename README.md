
# Recipe Management System Application

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#Technologies-Used)
- [Data Models](#Data-Models)
- [Project Structure](#Project-Structure)
- [Controllers](#Controllers)
- [API Endpoints](#API-Endpoints)
- [Authentication](#Authentication)
- [Project Summary](#Project-Summary)

- [Acknowledgments](#Acknowledgments)
- [Support ](#Support)



### Overview
This Recipe Management System Application  is designed to handle various types of relationships ( many-to-one, and many-to-many) among data models and provide CRUD (Create, Read, Update, Delete) operations for each model. The portal includes models for Admin, User, FoodItem,  and Order, along with their relationships.

### Technologies Used
- Framework: Spring Boot
- Language: Java
- Database: MySQL
- Dependency Management: Maven
- Deployment : AWS
### Data Models
### User
- Represents a user of the application.
- Contains fields for user information:
    - id
    - Name
    - Email
    - Password
### Comment
- Represents a user's comments.
- Contains fields for order information:
    -  ID
    -  UserComment (the associated user)
### Admin
- Represents a Admin of the application.
- Contains fields for Admin information:
    - id
    - Name
    - Email(@admin.com)
    - Password
  ### Recipe
- Represents Recipes of the application.
- Contains fields for Recipes information:
    - RecipeId
    - RecipeName
    - List of RecipeIngredients
    - RecipeInstructions
### AuthenticationToken
- Represents an authentication token for User and Admin sessions.
- Contains fields for token information:
    - Token ID
    - Token
    - Token Creation Date
    - TokenUserType (associated user & admin)

### Project Structure
The project structure is organized as follows:

- src/main/java: Contains the Java source code.
- com.example.MCT.RecipeManagementSystem.controller: Contains controller classes for handling HTTP requests.
- com.example.MCT.RecipeManagementSystem.model: Contains entity classes for the data models.
- com.example.MCT.RecipeManagementSystem.repository: Contains repository interfaces for database operations.
- com.example.MCT.RecipeManagementSystem.service: Contains service classes for business logic.
- src/main/resources: Contains application configuration files, including application.properties or application.yml.
- src/test: Contains test classes.
- Setup
  Clone the repository to your local machine:

- bash
- Copy code
- git clone
    - https://github.com/DharmendraShekhawat/MCT_Recipe_Management_System
- Open the project in your chosen IDE.

- Configure your database connection in the application.properties or application.yml file.

- Run the Spring Boot application.

## Controllers
### UserController
This controller handles user and order related operations:

- Sign In: Allows users to sign in by providing valid credentials.
- Sign Up: Allows new users to create an account.
- sign OUt: Allows signIn user to signOut.
- Update User Details: Enables users to update their profile information.
- Add comment: only authenticated user allowed to comment on recipe.
### AdminController
This controller handles Admin and FoodItem related operations:

- Add Admin: add admin .
- Add Recipe : only Admin can add Recipe.
- Update Recipe : only Admin can update recipe.
- Delete Recipe : only Admin can delete recipe.
## API Endpoints
### User Endpoints
- POST   user/signin : Sign in with user credentials.
- POST   user/signup: Create a new user account.
- DELETE user/signOut : sign out a sign in user.
- POST   comment : user can comment on recipe.
- GET    random/user/recipes : get all recipes of a user.

### Admin Endpoints
- POST admin : add a new admin.
- POST recipe : add a recipe by admin.
- PUT  recipe : update a recipe by admin using recipe object.
- DELETE recipe : delete a recipe by admin using recipe id.
- GET recipe : get all recipes by admin.
## Authentication
- User authentication is required for most endpoints.
- Use the token received during sign-in for all user operations.



## Project Summary
- This Recipe Management System Application is built using Spring Boot and Java.
- It allows users to perform CRUD operations on User,Admin,Comment entities.
- The project follows a structured architecture with controllers, services, and repositories.
- Data is stored in a MySQL database with appropriate relationships.
- Deployed on AWS server.

## Acknowledgments

We would like to express our gratitude to the following individuals and projects for their contributions and support to the Employee Address Application :

- **[Dharmendra Shekhawat]**: Lead developer and project coordinator.
- **[maven]**: We utilized [maven] for [dependencies] in our project.
- **Stack Overflow Community**: For their invaluable assistance in resolving technical challenges.
- **SpringBoot Framework**: For providing a robust and efficient platform for building our application.
- **AWS**: for proving a public server to deploy the Application.

We appreciate the  effort and support that made this project possible.



## Support

For support, email dharmendrashekhawat1403@gmail.com.

## thank you.





