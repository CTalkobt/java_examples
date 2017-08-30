#!/bin/bash
cd ../main
echo "| **Link** | **Usage** | **Description** |"
echo "| ---- | ---- | ----------- |"
for file in `find . -name "*.rmd" -print`; do
	url=`echo ${file} | sed "s;^./;;" | sed "s;.rmd;.java;"`	
	baseName=`basename $file | sed "s/.rmd//"`
	simple=`cat $file | grep '^simple:' | sed 's;^simple: ;;'`
	description=`cat $file | grep '^description: '| sed 's;^description: ;;'`
    usage=`cat $file | grep "^usage: " | sed "s;^usage: ;;"`

	echo "| [${simple:-$baseName}](src/main/${url}) | ${usage} |${description} |"
done


