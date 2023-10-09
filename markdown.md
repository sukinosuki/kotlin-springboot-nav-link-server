导航管理服务端

## 需要准备什么

- java17 (java8可能也可以?)

- kotlin (可能idea会自动下载)

- mysql8

## 接口文档

### 用户 User

- 注册: 
```markdown
POST: /api/v1/auth/register

参数:
username: string
password: string

响应
code: number
msg: string
data: string // token
```

- 登录
```markdown
POST: /api/v/auth/login

// 参数
username: string
password: string

// 响应
data: string // token
```

### 分类 Category
- 列表
```markdown
GET: /api/v1/category
```

- 新增
```markdown
POST: /api/v1/category
参数:
name: string
pid: number? // 父级分类id，传0或者null则设置为一级分类 (带?的为非必传)
sort: number? // 排序，默认0
```

- 更新
```markdown
PUT: /api/v1/category/:id // 如: PUT方法请求 '/api/v1/category/1' 即更新id=1的分类
参数:
name: string
pid: number? // 父级分类id，传0或者null则设置为一级分类
sort: number? // 排序，默认0
```

- 删除
```markdown
DELETE: /api/v1/category/:id // 如: DELETE方法请求 '/api/v1/category/1' 即删除id=1的分类
```

### 导航 NavLink
- 新增
```markdown
POST: /api/v1/nav-link

参数:
name: string // 导航名称
url: string // 导航链接
categoryId: number // 分类id
logo: string? // 导航logo，可为空
sort: number? // 排序，可为空
```

- 编辑
```markdown
PUT: /api/v1/nav-link/:id

参数:
name: string // 导航名称
url: string // 导航链接
categoryId: number // 分类id
logo: string? // 导航logo，可为空
sort: number? // 排序，可为空
```

- 删除
```markdown
DELETE: /api/v1/nav-link/:id
```

- 列表(树形分类导航列表)
```markdown
GET: /api/v1/nav-link
```