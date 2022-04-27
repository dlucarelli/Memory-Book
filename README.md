# Memory Book
[Github Profile](https://github.com/dlucarelli)
This application is for parents to store memories: stories of childhood, pictures, songs their kids loved to listen to. They can save a profile and include all their family memories in a single place. 

##Contents
- [Daily Progress](#Daily-Progress)
- [User Stories](#User-Stories)
- [Rubric](https://docs.google.com/document/d/1HLKr_fA5qU1hv2aJd7WJ616jocwgIsq72M2WDrX2Fqo/edit?usp=sharing)
- [Schema Diagram](/diagrams/Schema.PNG)
- [Mockup](https://www.figma.com/file/j6vJprIUQrsd7G65hQZ4fY/Untitled?node-id=0%3A1) *please email [dyllucar@gmail.com](mailto:dyllucar@gmail.com) for access*
- [Technical Architecture](/diagrams/Technical%20Architecture.drawio.png)
- [Technical Challenges](#Technical-Challenges)
- [Lessons and Takeaways](#Lessons-and-Takeaways)

## Daily Progress

4/26/2022
Updated styles and front end features to be consistent across logged in pages

4/25/2022(90%)
Updating README.md on progress, Updated memory and children functionality to better tie to user

4/24/2022(75%)
Updating frontend pages to uniformity

4/23/2022(60%)
Adding searchability in memory class, updating CRUD functions to allow date, cleaning child and memory controller to better represent functionality

4/22/2022(60%)
Worked on user implementation with child and memory, stuck on principal usage

4/21/2022(59%)
Added Sang's Spring Security information to application, fixed issue with not loading login

4/20/2022(55%)
Removed rest controller that wasn't effective part of application

4/19/2022(55%)
Used web security application demo to try web security, then reverted after not making real progress

4/18/2022(55%)
Created navbar and page layout template

4/15/2022(40%)
Models and structure for application finished and layout design set for implementation


## User Stories
- As a parent, I want a place to store family memories
- As a parent, I want to be able to access my children's stories from anywhere
- As a parent, I want to be able to save a page for each of my children
- As a parent, I want to be able to search for memories on a specific date
- As a user, I want to be able to change my information
- As a user, I want to create a profile so I can keep my information consistent (future)
- As an admin, I want to be able to see the data that is in the database from the application (future)
- As an admin, I want to be able to assist in making users (future)

##Technical Challenges
- Spring Security and registration were difficult to implement. The persistent user with role privileges took some time to operate correctly without each user having access to all user information.
- Using CSS and Thymeleaf together was difficult in making the stylings show up, though that was sometimes limited by allowances in the Spring Security configuration as well.

##Lessons and Takeaways
- It is extremely important to take your project piecemeal, and have deadlines to accomplish any individual part. Time management is as important as technical skill
- Not everything needs to be original and unique code, or be novel and self discovered. Help from people with more/different experience is great, and you can use solutions that already exist
- Be realistic about what is accomplishable in the time given. Make sure you can meet the requirements before extra features are added.