@echo off
cd /d "%~dp0"
docker compose up -d --wait db
if errorlevel 1 (
  echo Database did not start. Check that Docker Desktop is open.
  pause
  exit /b 1
)
docker compose build app
if errorlevel 1 (
  echo Application build failed.
  pause
  exit /b 1
)
docker compose run --rm app
pause
