## The directory is for the back-end build .

## The front-end is developed with Vue and wrapped in the directory "frontend".

### Modules (Interfaces)

#### Controller (转发前端页面的请求给 service 层)

* ConsultationinfoController
  * patientList (Request)
  * queryPatient (Get)
  * updatePatient (Put)
  * deletePatientById (DeleteMapping)
  * insertPatient (Post)
  * deletePatients (Delete)
* DepartmentinfoController
  * list (Get)
* EmpinfoController
  * findByDid (Request)
  * insertEmp (Request)
* MediacalrecordController
  * insertMedicalRecord (Post)
  * list (Request)
  * detail (Request)
  * batchDelete (Request)
  * update (Post)
* UserinfoController
  * findByPhone (Request)
  * logout (Request)
  * login (Post)
  * sendSms (Request)


#### Service (排列组合Dao 实现业务逻辑)

* ConsultationService     
  * selectByPage
  * selectById
  * updateById
  * deleteById
  * deletePatients
  * insertConsultation
* DepartmentinfoService
  * selectAll    返回所有科室
* EmpinfoService
  * findByid
  * insertEmp
* MedicalrecordService
  * insertMedcialrecord
  * selectByPage
  * selectById
  * batchDelete
  * update
* UserService
  * selectByPhone

#### Dao (Mapper, 执行CRUD)

* ConsultationMapper
* DepartmentinfoMapper
* EmpinfoMapper
* MedicalrecordMapper
* UnserinfoMapper

#### Entity (定义数据库对象，对象属性对应相应数据表中的字段)

* Consultation	病人信息行
* Departmentinfo	 科室行
* Empinfo    医生行
* Medicalrecord    病例行 (相当于我们的Cases)
* Userinfo    用户行（存疑）