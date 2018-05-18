test: FORCE
	mvn test

doc: FORCE
	mvn javadoc:javadoc

jar: FORCE
	mvn clean compile assembly:single

run: FORCE
	java -jar dist/g10-iteration-X.jar

preview: FORCE
	mvn exec:java -Dexec.mainClass="be.ac.ulb.infof307.g10.utils.PreviewData"

release: FORCE doc jar
	git add dist doc --force

# force target, see https://www.gnu.org/software/make/manual/html_node/Force-Targets.html
FORCE:
