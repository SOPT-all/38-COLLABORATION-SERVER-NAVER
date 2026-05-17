#!/bin/bash
set -e

echo "▶ Pulling latest main..."
git checkout -- gradlew
git pull origin main
chmod +x gradlew

echo "▶ Building..."
./gradlew clean bootJar

echo "▶ Stopping old process..."
pkill -f 'build/libs/.*\.jar' || true
sleep 2

echo "▶ Starting server..."
set -a; source .env; set +a
nohup java -jar build/libs/*.jar > nohup.out 2>&1 &

echo "✅ Deployed. PID: $!"
echo "   tail -f nohup.out 으로 로그 확인"