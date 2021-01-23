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
| guestbook.com/api/guestComments  | GET         |   200 OK        | Return the GuestBook entries                    |

