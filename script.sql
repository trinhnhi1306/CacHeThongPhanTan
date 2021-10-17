USE [VEMAYBAY]
GO
/****** Object:  Table [dbo].[TICKET]    Script Date: 17/10/2021 23:47:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TICKET](
	[ID] [int] NOT NULL,
	[SOLD] [bit] NOT NULL,
	[BLOCK] [bit] NOT NULL,
 CONSTRAINT [PK_TICKET] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (1, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (2, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (3, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (4, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (5, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (6, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (7, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (8, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (9, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (10, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (11, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (12, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (13, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (14, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (15, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (16, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (17, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (18, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (19, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (20, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (21, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (22, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (23, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (24, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (25, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (26, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (27, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (28, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (29, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (30, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (31, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (32, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (33, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (34, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (35, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (36, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (37, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (38, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (39, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (40, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (41, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (42, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (43, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (44, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (45, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (46, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (47, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (48, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (49, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (50, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (51, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (52, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (53, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (54, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (55, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (56, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (57, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (58, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (59, 1, 1)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (60, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (61, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (62, 0, 0)
GO
INSERT [dbo].[TICKET] ([ID], [SOLD], [BLOCK]) VALUES (63, 0, 0)
GO
USE [master]
GO
ALTER DATABASE [VEMAYBAY] SET  READ_WRITE 
GO