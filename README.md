# University Database Design & Management System

A university database design assignment from the 2020–2021 academic year, with a Java command-line CRUD application using JDBC and MySQL. It models schools, campuses, departments, instructors, supervisors, programs of study, courses, students, and their relationships.

**Academic project by Konstantinos-Andreas Morfis and Ilias Barmpounis.** The repository packages the original assignment for local use; it does not represent production-ready university software.

## Run on Windows with Docker Desktop

1. Start Docker Desktop.
2. Open the extracted project folder and double-click `start_windows.bat` (or run it from Command Prompt).
3. Wait for the first image download and Java build. The console displays the main menu. Select `4` to view tables or `1` to insert records. Enter `0` to exit.
4. To launch again, run `start_windows.bat` again. MySQL data persists in the Docker volume.

Alternatively, from the project folder:

```sh
docker compose up -d --wait db
docker compose build app
docker compose run --rm app
```

Stop the database with `docker compose down`. To start with a **fresh empty database**, run `docker compose down -v` (this permanently deletes records entered in this local project).

The console application has no browser address or graphical interface. Docker Desktop and Docker Compose are required; Java and MySQL are supplied by the containers.

## Contents

- `src/main/java/Main.java`: original menu-based Java application, with configurable JDBC connection and parameterized input for two report queries.
- `database/schema.sql`: MySQL adaptation of the assignment's physical model, loaded automatically when the database volume is first created.
- `original/Physical Model.ddl`: the original Oracle Data Modeler export, kept for reference. It is **not** the script loaded by MySQL.
- `pom.xml`, `Dockerfile`, `compose.yaml`: Java dependency/build and local runtime setup.

The coursework report is omitted because it contains the students' registration numbers and email addresses. The original ZIP remains a separate private source.

## Notes on the academic implementation

The inherited application frequently executes `SET FOREIGN_KEY_CHECKS=0` while performing CRUD operations. This can allow records with invalid relationships. The original schema also has a circular association/campus relationship, and the original report query uses the assignment's historical year `2021`. These behaviors are retained to keep the assignment recognizable; use this only for a local demo with sample data.

No real university data is included. The credentials in `compose.yaml` are local demo credentials and the database is not exposed to the host network.
