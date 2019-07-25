xcopy /s /i ".mvn" "employee-gateway-api\.mvn" /Y
xcopy /s /i ".mvn" "employee-service\.mvn" /Y
xcopy /s /i ".mvn" "service-discovery\.mvn" /Y
xcopy /s /i ".mvn" "employee-web\.mvn" /Y
@echo off
echo "Configuration Successfull.."

timeout 10