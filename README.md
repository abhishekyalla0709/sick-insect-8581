# sick-insect-8581
COURSE MANAGEMENT SYSTEM

Course Management System is an application to track and maintain the track of courses and batches that are running in an institution. 
There can be n number of courses and m number of batches running simulataneously.
This application helps us to track and maintain the status of each and every batch.

![Untitled drawing (1)](https://user-images.githubusercontent.com/112754517/221499389-a19b5a34-0854-4931-9e7e-9a6eecaa2d6e.png)

Domain Description: <br>
In an educational Institute there are several courses running parallel every day. For every course there are several batches at same/different time. Every batch has a session wise/day wise schedule. It will be difficult for the Faculty Head to know the status of every batch i.e what is the session taught at each day in a batch. So the Automated Course Monitoring System will keep the records of all the courses,batches,faculties and the daywise update for every batch. It will also help the Faculty Head to maintain the course plan.

Types of users:
<br>

• Administrator.

• Faculty

Role of Administrator:
<br>

• Login to his account

• Create, Update, View Course.

• Create, Update, View Batch. A batch is related to a course.

• Create, Update, View Faculty.

• Allocate faculty to a batch.

• Create, Update, View Course plan.

• View the Day wise update of every batch.

• Generate Report for every batch.

Role of Faculty:
<br>

• Login to his/her account

• View the Course Plan

• Fill up the day wise planner.

• Update his/her password.

Tables:
<br>

Faculty:
<br>

• faculty_id

• faculty_name

• faculty_address

• faculty_mobileno

• faculty_email

• faculty_username

• faculty_password

Course: 
<br>

• course_id

• course_name

• course_fee

• course_des

Batch:
<br>

• batch_id:

• course_id:

• faculty_id:

• number_of_students;

• batch_start_date

• duration

CoursePlan:

• plan_id

• batch_id

• dayNumber

• topic

• status
