## The directory is for the back-end build .

### Docker Config
docker port mapped to 3383 (avoid to be confused with other Docker instance )
```
$ docker run --name clinic -e MYSQL_ROOT_PASSWORD=123456 -p 3383:3306 -d mysql:8.0 
```

## AI

### python environment
We have two python environment py36tf110 and pytorch140.
The dependencies they need are in the conda_env_dependencies folder

### raw data
In the BERT model, raw data is scratched using Python. The data and the crawling code is in the hdf_data folder. Also, the data can be found in nlp_model/hku_proj/imit_bert_2/data/. They have been divided into train data, dev data and test data.

In the BERT-GPT model, data can be found at nlp_model/hku_proj/medical/BERT-GPT/data

### how to train model

BERT: Run /nlp_model/hku_proj/imit_bert_2/train.sh to train the data.

BERT-GPT: The author has provided a pretrained model using hdf data.

### how to predict

BERT: Run /nlp_model/hku_proj/imit_bert_2/predict.sh to predict the result. The result will be in the /output 

BERT-GPT: Run /nlp_model/hku_proj/medical/BERT-GPT/start.sh to predict the result. The result will be in the same folder

### how to start the server

In the server, run /nlp_model/hku_proj/imit_bert_2/server_one.py and /nlp_model/hku_proj/medical/BERT-GPT/server_one.py separately.


### Originality and Reference Declaration

* Our AI engine is based on an open-source BERT model, so the framework of the AI engine refers to [BERT: Pre-training of deep bidirectional transformers for language understanding](https://github.com/google-research/bert) and [MedDialog: Large-scale Medical Dialogue Dataset](https://github.com/UCSD-AI4H/Medical-Dialogue-System)
* Our frontend design is based on 
* Our backend design is based on an open-source framework Spring Boot. 
  * The skeleton of dependency library configuration defined in the file "pom.xml" was referred to [maven.apache.org](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#:~:text=Available%20Variables-,What%20is%20a%20POM%3F,default%20values%20for%20most%20projects.). 
  * The skeleton of the Java Web framework was referred to [Spring Boot](https://spring.io/guides/gs/spring-boot/).
* We hereby declare that except the parts mentioned above, all other parts of source code are done by us.

