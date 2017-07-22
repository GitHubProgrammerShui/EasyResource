package org.resource.constant;

public class PhotoFileSuffixName extends FileSuffixName{
	//图像文件后缀名
	/**
	 *     PNG（Portable Network Graphics）是一种新兴的网络图像格式。在1994年底
	 * ，由于Unysis公司宣布GIF拥有专利的压缩方法，要求开发GIF软件的作者须缴交一
	 * 定费用，由此促使免费的png图像格式的诞生。PNG一开始便结合GIF及JPG两家之长
	 * ，打算一举取代这两种格式。1996年10月1日由PNG向国际网络联盟提出并得到推荐
	 * 认可标准，并且大部分绘图软件和浏览器开始支持PNG图像浏览，从此PNG图像格式
	 * 生机焕发。<br>
	 *     PNG是目前保证最不失真的格式，它汲取了GIF和JPG二者的优点，存贮形式丰
	 * 富，兼有GIF和JPG的色彩模式；它的另一个特点能把图像文件压缩到极限以利于网
	 * 络传输，但又能保留所有与图像品质有关的信息，因为PNG是采用无损压缩方式来
	 * 减少文件的大小，这一点与牺牲图像品质以换取高压缩率的JPG有所不同；它的第
	 * 三个特点是显示速度很快，只需下载1/64的图像信息就可以显示出低分辨率的预览
	 * 图像；第四，PNG同样支持透明图像的制作，透明图像在制作网页图像的时候很有
	 * 用，我们可以把图象背景设为透明，用网页本身的颜色信息来代替设为透明的色彩
	 * ，这样可让图像和网页背景很和谐地融合在一起。<br>
	 *     PNG的缺点是不支持动画应用效果，如果在这方面能有所加强，简直就可以完
	 * 全替代GIF和JPEG了。Macromedia公司的Fireworks软件的默认格式就是PNG。现在
	 * ，越来越多的软件开始支持这一格式，而且在网络上也越来截止流行。<br>
	 */
	public final static String PNG=".png";
	/**
	 *     GIF是英文Graphics Interchange format（图形交换格式）的缩写。顾名
	 * 思义，这种格式是用来交换图片的。事实上也是如此，上世纪80年代，美国一家著
	 * 名的在线信息服务机构CompuServe针对当时网络传输带宽的限制，开发出了这种
	 * GIF图像格式。<br>
	 *     GIF格式的特点是压缩比高，磁盘空间占用较少，所以这种图像格式迅速得到
	 * 了广泛的应用。 最初的GIF只是简单地用来存储单幅静止图像（称为GIF87a），后
	 * 来随着技术发展，可以同时存储若干幅静止图象进而形成连续的动画，使之成为当
	 * 时支持2D动画为数不多的格式之一（称为GIF89a），而在GIF89a图像中可指定透明
	 * 区域，使图像具有非同一般的显示效果，这更使GIF风光十足。目前Internet上大
	 * 量采用的彩色动画文件多为这种格式的文件，也称为GIF89a格式文件。<br>
	 *     此外，考虑到网络传输中的实际情况，GIF图像格式还增加了渐显方式，也就
	 * 是说，在图像传输过程中，用户可以先看到图像的大致轮廓，然后随着传输过程的
	 * 继续而逐步看清图像中的细节部分，从而适应了用户的"从朦胧到清楚"的观赏心理
	 * 。目前Internet上大量采用的彩色动画文件多为这种格式的文件。<br>
	 *     但GIF有个小小的缺点，即不能存储超过256色的图像。尽管如此，这种格式仍
	 * 在网络上大行其道应用，这和GIF图像文件短小、下载速度快、可用许多具有同样
	 * 大小的图像文件组成动画等优势是分不开的。<br>
	 */
	public final static String GIF=".gif";
	/**
	 *     jpg全名是JPEG。JPEG图片以 24 位颜色存储单个位图。JPEG 是与平台无关的格式
	 * ，支持最高级别的压缩，不过，这种压缩是有损耗的。渐近式 JPEG 文件支持交错。<br>
	 */
	public final static String JPG=".jpg";
	/**
	 *     JPEG也是常见的一种图像格式，它由联合照片专家组（Joint Photographic
	 * Experts Group）开发并以命名为"ISO 10918-1"，JPEG仅仅是一种俗称而已。
	 * JPEG文件的扩展名为.jpg或.jpeg，其压缩技术十分先进，它用有损压缩方式去除
	 * 冗余的图像和彩色数据，获取得极高的压缩率的同时能展现十分丰富生动的图像，
	 * 换句话说，就是可以用最少的磁盘空间得到较好的图像质量。<br>
	 *     同时JPEG还是一种很灵活的格式，具有调节图像质量的功能，允许你用不同的
	 * 压缩比例对这种文件压缩，比如我们最高可以把1.37MB的BMP位图文件压缩至20.3
	 * KB。当然我们完全可以在图像质量和文件尺寸之间找到平衡点。<br>
	 *     由于JPEG优异的品质和杰出的表现，它的应用也非常广泛，特别是在网络和光
	 * 盘读物上，肯定都能找到它的影子。目前各类浏览器均支持JPEG这种图像格式，因
	 * 为JPEG格式的文件尺寸较小，下载速度快，使得Web页有可能以较短的下载时间提
	 * 供大量美观的图像，JPEG同时也就顺理成章地成为网络上最受欢迎的图像格式。<br>
	 */
	public final static String JPEG=".jpeg";
	/**
	 *  BMP是英文Bitmap（位图）的简写，它是Windows操作系统中的标准图像文件格式，
	 *  能够被多种Windows应用程序所支持。随着Windows操作系统的流行与丰富的Windows
	 *  应用程序的开发，BMP位图格式理所当然地被广泛应用。这种格式的特点是包含的图像
	 *  信息较丰富，几乎不进行压缩，但由此导致了它与生俱生来的缺点--占用磁盘空间过大
	 *  。所以，目前BMP在单机上比较流行。<br>
	 */
	public final static String BMP=".bmp";
	/**
	 *     TIFF（Tag Image File format）是Mac中广泛使用的图像格式，它由Aldus和
	 * 微软联合开发，最初是出于跨平台存储扫描图像的需要而设计的。它的特点是图像
	 * 格式复杂、存贮信息多。正因为它存储的图像细微层次的信息非常多，图像的质量
	 * 也得以提高，故而非常有利于原稿的复制。<br>
	 *     该格式有压缩和非压缩二种形式，其中压缩可采用LZW无损压缩方案存储。不
	 * 过，由于TIFF格式结构较为复杂，兼容性较差，因此有时你的软件可能不能正确识
	 * 别TIFF文件（现在绝大部分软件都已解决了这个问题）。目前在Mac和PC机上移植
	 * TIFF文件也十分便捷，因而TIFF现在也是微机上使用最广泛的图像文件格式之一。
	 */
	public final static String TIFF=".tiff";
	/**
	 *     这是著名的Adobe公司的图像处理软件Photoshop的专用格式Photoshop
	 * Document（PSD）。PSD其实是Photoshop进行平面设计的一张"草稿图"，它里面包
	 * 含有各种图层、通道、遮罩等多种设计的样稿，以便于下次打开文件时可以修改上
	 * 一次的设计。在Photoshop所支持的各种图像格式中，PSD的存取速度比其它格式快
	 * 很多，功能也很强大。由于Photoshop越来越被广泛地应用，所以我们有理由相信
	 * ，这种格式也会逐步流行起来。
	 */
	public final static String PSD=".psd";
	/**
	 *     SVG可以算是目前最最火热的图像文件格式了，它的英文全称为Scalable
	 * Vector Graphics，意思为可缩放的矢量图形。它是基于XML（Extensible
	 * Markup Language），由World Wide Web Consortium（W3C）联盟进行开发的。严
	 * 格来说应该是一种开放标准的矢量图形语言，可让你设计激动人心的、高分辨率的
	 * Web图形页面。用户可以直接用代码来描绘图像，可以用任何文字处理工具打开
	 * SVG图像，通过改变部分代码来使图像具有互交功能，并可以随时插入到HTML中通
	 * 过浏览器来观看。<br>
	 *     它提供了目前网络流行格式GIF和JPEG无法具备了优势：可以任意放大图形显
	 * 示，但绝不会以牺牲图像质量为代价；字在SVG图像中保留可编辑和可搜寻的状态
	 * ；平均来讲，SVG文件比JPEG和GIF格式的文件要小很多，因而下载也很快。可以相
	 * 信，SVG的开发将会为Web提供新的图像标准。
	 */
	public final static String SVG=".svg";
	/**
	 *     PCX格式是ZSOFT公司在开发图像处理软件Paintbrush时开发的一种格式，这是
	 * 一种经过压缩的格式，占用磁盘空间较少。由于该格式出现的时间较长，并且具有
	 * 压缩及全彩色的能力，所以现在仍比较流行。<br>
	 */
	public final static String PCX=".pcx";
	/**
	 *     DXF（Autodesk Drawing Exchange format）是AutoCAD中的矢量文件格式，它
	 * 以ASCII码方式存储文件，在表现图形的大小方面十分精确。许多软件都支持DXF格
	 * 式的输入与输出。
	 */
	public final static String DXF=".dxf";
	/**
	 *     WMF（Windows Metafile format）是Windows中常见的一种图元文件格式，属
	 * 于矢量文件格式。它具有文件短小、图案造型化的特点，整个图形常由各个独立的
	 * 组成部分拼接而成，其图形往往较粗糙。
	 */
	public final static String WMF=".wmf";
	/**
	 *     EMF（Enhanced Metafile）是微软公司为了弥补使用WMF的不足而开发的一种
	 * Windows 32位扩展图元文件格式，也属于矢量文件格式，其目的是欲使图元文件更
	 * 加容易接受。
	 */
	public final static String EMF=".emf";
	/**
	 * 
	 */
	public final static String EPS=".eps";
}
