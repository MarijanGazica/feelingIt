# feelingIt

EXTREMELY basic tryout of [Spark Framework](http://sparkjava.com/)

No memory, no users, global server state...

[Hosted on Heroku](http://feelingit.herokuapp.com/) if anyone wants to see it working.



# How to use it

Base url: `https://feelingit.herokuapp.com`

| Method        | Path          | Description  |
| ------------- | ------------- | ----- |
| GET           | /             | homepage with a really ugly image, use it to see if server is up and running |
| GET           | /all          | get all possible feelings that server will accept |
| GET           | /my           | get all currently set feelings |
| DELETE        | /my-all       | delete all currently set feelings |
| DELETE        | /my           | delete only one of currently set feelings (from body) |
| POST          | /my           | add only one of available feelings (from body) |

Each time the server hibernates, it cleares the state. So long, feelings...
