## Project Link (Downloadable, available before 01/01/2023)

Since the size of our source codes (with a machine learning model of over 8 GB, even not taking the data set into account) is quite large, we packed our project codes in the [OneDrive-HKU](https://connecthkuhk-my.sharepoint.com/:f:/g/personal/roomay_connect_hku_hk/EmfaxbA9aEVHlI0T5zhoSaoB-lys9hz28TJMOWPiFVIqww?e=7fhvm8) folder. Once it is downloaded, please follow the guide as follows to test all the service.

## Overview

The source codes consist of two parts: the frontend & backend in  <code>/Clinic</code> and the AI model in <code>/nlp_engine</code> with its environment configuration in <code>/conda_env_dependencies</code>. 

The raw data set can be found in <code>/hdf_data</code>.

The environment configurations and boot steps are demonstrated as follows.

## Originality and Reference Declaration

* Our AI engine is based on an open-source BERT model, so the framework of the AI engine refers to [BERT: Pre-training of deep bidirectional transformers for language understanding](https://github.com/google-research/bert) and [MedDialog: Large-scale Medical Dialogue Dataset](https://github.com/UCSD-AI4H/Medical-Dialogue-System).
* Our frontend is based on a template from a material website [jqueryfuns](http://www.jqueryfuns.com/resource/4341). We also use a useful plug-in component [sweetalert2](https://sweetalert2.github.io/). The skeleton of our project applies this template, which is based on bootstrap. 
* Our backend design is based on an open-source framework Spring Boot. 
  * The skeleton of dependency library configuration defined in the file "pom.xml" was referred to [maven.apache.org](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#:~:text=Available%20Variables-,What%20is%20a%20POM%3F,default%20values%20for%20most%20projects.). 
  * The skeleton of the Java Web framework was referred to [Spring Boot](https://spring.io/guides/gs/spring-boot/).
* We hereby declare that except the parts mentioned above, all other parts of source code are originally done by us.

## Frontend

After you start the CloudApplication.java, you can access the main page of our website by http://localhost:8080/index.html 



## Backend

The main method can be found in the path <code>/Clinic/src/main/java/com/dzqc/cloud/CloudApplication.java</code>.

### Docker Config

Docker port mapped to 3383 (avoid to be confused with other Docker instance )
```sh
$ docker run --name clinic -e MYSQL_ROOT_PASSWORD=123456 -p 3383:3306 -d mysql:8.0 
```

## AI

### python environment
We have two python environment, py36tf110 and pytorch140.
The dependencies they need are in the <code>conda_env_dependencies</code>  folder

### raw data
In the BERT model, raw data is scratched using Python. The data and the crawling code is in the <code>hdf_data</code> folder. Also, the data can be found in <code>nlp_model/hku_proj/imit_bert_2/data/</code>. They have been divided into train data, dev data and test data.

In the BERT-GPT model, data can be found at <code>nlp_model/hku_proj/medical/BERT-GPT/data</code>.

### how to train model

BERT: to train the data, run the command:

```sh
$ /nlp_model/hku_proj/imit_bert_2/train.sh
```

BERT-GPT: The author has provided a pretrained model using <code>hdf_data</code>.

### how to predict

BERT: Run the command  to predict the result. The result will be in the <code>/output</code> 

```sh
$ /nlp_model/hku_proj/imit_bert_2/predict.sh
```

BERT-GPT: Run the command to predict the result. The result will be in the same folder.

```sh
$ /nlp_model/hku_proj/medical/BERT-GPT/start.sh
```

### how to start the server

In the server, run the commands to start:

```sh
$ /nlp_model/hku_proj/imit_bert_2/server_one.py
$ /nlp_model/hku_proj/medical/BERT-GPT/server_one.py
```
