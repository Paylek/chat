# Chat
## ✨Spring Web: Anonymous online chat✨

## Installation

Chat requires MYSQL driver is being installed.

Before running in IntelliJ IDEA change Run/Debug configuration (click ChatApplication on 'Runner panel') -> Edit Configurations... -> Modify options -> Override configuration properties -> (Click +) -> add:

Override configuration properties:

| Name                       | Value (for example)                                                                                                                         |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| SPRING_DATASOURCE_URL      | jdbc:mysql://localhost:3306/chat?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false&createDatabaseIfNotExist=true
| SPRING_DATASOURCE_NAME     | name                                                                                                                            
| SPRING_DATASOURCE_PASSWORD | password                                                                                                                            

Run/Debug
Second and next Run/Debug with open connection through Database connection in IntelliJ IDEA or Workbench can lead to lost first user authentication. Try to authenticate user again or close/remove the mentioned connections and re-Run/Debug.

