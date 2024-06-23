build-unit:
	docker build -t test_docker -f Dockerfile.dev .

run-unit:
	docker run -it --rm --name="test_docker" test_docker bash

unit-test:
	for x in *;do \
		{
			cd $$x && mvn test && cd .. ; \
		} || {
			echo "Failed at $${x}"
		}
	done;

unit-tests-folder:
	cp Makefile /usr/src/app/Projects && cd /usr/src/app/Projects && make unit-test	
	cp Makefile /usr/src/app/Libraries && cd /usr/src/app/Libraries && make unit-test
	pwd
	echo "RUN SUCCESSFUL"

unit-test-docker:
	docker compose build merve-unit-test 
	docker compose run --rm merve-unit-test make unit-tests-folder