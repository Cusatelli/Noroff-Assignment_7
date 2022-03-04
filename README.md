<div id="top"></div>

<div align="center">
  <img src="/resources/Logo.png" alt="Logo" width="75%">
  <h3 align="center">Noroff Assignment 7</h3>
  <p align="center">
    Movie Characters API
    <br />
    <a href="https://noroff-assignment7.herokuapp.com/swagger-ui/index.html">View Demo</a>
  </p>
</div>

# Table of Contents
1. [About the Project](#about-the-project)
2. [Build & Deploy](#build--deploy)
2. [Install](#install)
4. [Usage](#usage)
5. [Demo](#demo)
6. [Maintainers](#maintainers)
7. [Contributing](#contributing)
8. [Conventions](#conventions)
9. [License](#license)
10. [Contact](#contact)

# About the project
### Movie Characters API
Create a PostgreSQL database using Hibernate and expose it through a Web API. Follow the guidelines given below, feel 
free to expand on the functionality. It must meet the minimum requirements prescribed.

1. **Set up the development environment.**  
Make sure you have installed at least the following tools:
   * IntelliJ with Java 17
   * PostgreSQL with PgAdmin
2. **Optional: Database diagrams**  
You can draw relationship diagrams of your database and include these in your GitLab repository.
3. **Use Hibernate to create a database with the following minimum requirements (See Appendix A 
for details):**
   * Create models and Repositories to cater for the specifications in Appendix A.
   * Create representations of domain object as to not overexpose your database data, this is detailed in Appendix B.
You can make these changes at a later stage in the assignment (i.e. When you want to test the endpoints).
4. **Create a Web API in Spring Web with the following minimum requirements (See Appendix B for 
details):**
   * Create controllers according to specifications in Appendix B.
   * Swagger/Open API documentation.

### Full PDF document:
<a href="/resources/Assignment%203_Java_Web%20API%20creation%20with%20Hibernate.pdf">Assignment: Create a Web API and database with Spring.</a>

# Build & Deploy
### STEP 1
```
Build a configuration class that exports/adds basic data source object type to application
```

### STEP 2
```
> Heroku container:push -a <APP-NAME-HEROKU> web

Docker auto builds the image & pushes it to repository

> Heroku container:release -a <APP-NAME-HEROKU> web

In Heroku -> Overview > Configure Add-ons > search for ‘postgres’ > add postgres >
Provides us with Config Var with database url.

Dockerfile get from gitlab GregLinklater

Config Vars:
> DATABASE_URL = <Auto-Set-Above>
> ISSUER_URL = <Security>
> JWKS_URI = <Security>
> CLIENT_ID = “client-id”
> APP_ORIGIN = <Github-Pages-URL>

Restart Dynos
```

# Install
```
git clone https://github.com/Cusatelli/Noroff-Assignment_7.git
cd Noroff-Assignment_7
```

# Usage
```
Open IntelliJ IDEA navigate to /src/main/java/com/noroff/noroffassignment_7/Application.java
Rigth click & press 'Run Application.java'
```

<p align="right">(<a href="#top">back to top</a>)</p>

# Demo
Heroku | Swagger-UI: <a href="https://noroff-assignment7.herokuapp.com/swagger-ui/index.html">https://noroff-assignment7.herokuapp.com/swagger-ui/index.html</a>

# Maintainers
[@Cusatelli](https://github.com/Cusatelli)  
[@OmarAbdiAli](https://github.com/OmarAbdiAli)

# Contributing
[@Cusatelli](https://github.com/Cusatelli)  
[@OmarAbdiAli](https://github.com/OmarAbdiAli)

<p align="right">(<a href="#top">back to top</a>)</p>

# Conventions

Format: `<type>(<scope>): <subject>`

`<scope>` is optional

- `feat`: (new feature for the user, not a new feature for build script)
- `fix`: (bug fix for the user, not a fix to a build script)
- `docs`: (changes to the documentation)
- `style`: (formatting, missing semi colons, etc; no production code change)
- `refactor`: (refactoring production code, eg. renaming a variable)
- `test`: (adding missing tests, refactoring tests; no production code change)
- `chore`: (updating grunt tasks etc; no production code change)

Read more: [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) v1.0.0

<p align="right">(<a href="#top">back to top</a>)</p>

# License
No active license.

<p align="right">(<a href="#top">back to top</a>)</p>

# Contact
Email: <a href="mailto:github.cusatelli@gmail.com">github.cusatelli@gmail.com</a>

<p align="right">(<a href="#top">back to top</a>)</p>
