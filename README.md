Your client is very simple. She just wants visitors to the application to 
leave comments about their experience. It's a very no frills service.

Features:

Any visitor can post their name and a comment to the Guestbook.
All visitors can see a list of every entry in the Guestbook.


## API Specifications
**Resource Summary**
| URI                              | HTTP Method |   HTTP Status   | Description                                           |
|----------------------------------|-------------|-----------------|-------------------------------------------------------|
| guestbook.com/api/guestComment   | POST        |   201 created   | Add comments to Guest Book                      |
| guestbook.com/api/guestComments  | GET         |   200 OK        | Return the GuestBook entries    


Feature I:
===========
Add name and comments Post method
url: https://guestbookcomments.herokuapp.com/api/guestComment

Request Body:
{
"name" : "username",
"comment" : "Hello guests"
}

Response : 201 Created

Feature II:
===========
Get list of guest book entries

url: https://guestbookcomments.herokuapp.com/api/guestComments

Response: 200 OK

[{"id":1,"name":"amal","comment":"hello"},
{"id":2,"name":"naga","comment":"Hi Guests"},
{"id":3,"name":"vijaya","comment":"this is another comment"},
{"id":4,"name":"Alicia","comment":"Hello guests"}]
