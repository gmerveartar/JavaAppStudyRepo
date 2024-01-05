build-unit:
	docker build -t test_docker -f Dockerfile.dev .

run-unit:
	docker run -it --rm --name="test_docker" test_docker bash

unit-tests:
	mvn test

unit-test-docker:
	docker compose build merve-unit-test 
	docker compose run --rm merve-unit-test make uni-tests