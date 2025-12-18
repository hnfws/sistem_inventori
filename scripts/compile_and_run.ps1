# Compile and run the sample Main.java
Set-StrictMode -Version Latest
javac -d out src/Main.java
if ($LASTEXITCODE -ne 0) { Write-Error "Compilation failed"; exit $LASTEXITCODE }
java -cp out Main
