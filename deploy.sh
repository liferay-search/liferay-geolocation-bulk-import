#!/bin/sh

set -o errexit ; set -o nounset

GRADLEW_DIR=../..

${GRADLEW_DIR}/gradlew deploy

cp build/libs/*.jar ${LIFERAY_BUNDLES_PORTAL_DIR}/deploy/